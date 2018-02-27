package com.aode.util;

import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;

/**
 * Created by moutian on 2017/6/27 0027.
 */

public class JsonBeanUtil {
    public JsonBeanUtil() {
    }

    public static Object toBean(JSONObject json, Class<?> objectClass) {
        Object object = null;

        try {
            if(json != null && !json.isNullObject()) {
                Class e = Class.forName(objectClass.getName());
                object = assignmentByClass(e, json);
            }
        } catch (ClassNotFoundException var4) {
            var4.printStackTrace();
        }

        return object;
    }

    private static Object assignmentByClass(Class<?> clazz, JSONObject json) {
        Object object = null;
        Field[] fileds = clazz.getDeclaredFields();

        try {
            object = clazz.newInstance();
            Field[] var7 = fileds;
            int var6 = fileds.length;

            for(int var5 = 0; var5 < var6; ++var5) {
                Field e = var7[var5];
                e.setAccessible(true);
                String value = json.optString(e.getName());
                if(e.getType() == Long.class) {
                    e.set(object, StringUtils.isBlank(value)?null:Long.valueOf(value));
                } else if(e.getType() == Integer.class) {
                    e.set(object, StringUtils.isBlank(value)?null:Integer.valueOf(value));
                } else if(e.getType() == Date.class) {
                    e.set(object, StringUtils.isBlank(value)?null: DateUtils.parseDate(value, new String[]{"yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd", "yyyy-MM-dd HH", "yyyy-MM-dd HH:mm"}));
                } else if(e.getType() == String.class) {
                    e.set(object, StringUtils.isBlank(value)?null:value);
                } else if(e.getType() == BigDecimal.class) {
                    e.set(object, StringUtils.isBlank(value)?null:new BigDecimal(value));
                } else if(e.getType() == Double.class) {
                    e.set(object, StringUtils.isBlank(value)?null:Double.valueOf(value));
                } else if(e.getType() == Float.class) {
                    e.set(object, StringUtils.isBlank(value)?null:Float.valueOf(value));
                }
            }
        } catch (IllegalArgumentException var9) {
            var9.printStackTrace();
        } catch (IllegalAccessException var10) {
            var10.printStackTrace();
        } catch (InstantiationException var11) {
            var11.printStackTrace();
        } catch (ParseException var12) {
            var12.printStackTrace();
        }

        return object;
    }

    private static Object assignmentByJson(Class<?> clazz, JSONObject json) {
        Object object = null;

        try {
            object = clazz.newInstance();
            Iterator iterator = json.keys();

            while(iterator.hasNext()) {
                String key = iterator.next().toString();
                Field field = clazz.getDeclaredField(key);
                field.setAccessible(true);
                String value = json.optString(field.getName());
                if(field.getType() == Long.class) {
                    field.set(object, StringUtils.isBlank(value)?null:Long.valueOf(value));
                } else if(field.getType() == Integer.class) {
                    field.set(object, StringUtils.isBlank(value)?null:Integer.valueOf(value));
                } else if(field.getType() == Date.class) {
                    field.set(object, StringUtils.isBlank(value)?null:DateUtils.parseDate(value, new String[]{"yyyy-MM-dd HH:mm:ss"}));
                } else if(field.getType() == String.class) {
                    field.set(object, StringUtils.isBlank(value)?null:value);
                } else if(field.getType() == BigDecimal.class) {
                    field.set(object, StringUtils.isBlank(value)?null:new BigDecimal(value));
                }
            }
        } catch (NoSuchFieldException var7) {
            ;
        } catch (SecurityException var8) {
            ;
        } catch (IllegalArgumentException var9) {
            ;
        } catch (IllegalAccessException var10) {
            ;
        } catch (InstantiationException var11) {
            ;
        } catch (ParseException var12) {
            ;
        }

        return object;
    }

    public static JSONObject toJson(Object object) {
        return assignmentByClass(object);
    }

    private static JSONObject assignmentByClass(Object object) {
        JSONObject json = new JSONObject();

        try {
            Field[] e = object.getClass().getDeclaredFields();
            Class clazz = object.getClass();
            Field[] var7 = e;
            int var6 = e.length;

            for(int var5 = 0; var5 < var6; ++var5) {
                Field field = var7[var5];
                field.setAccessible(true);
                String key = field.getName();
                String name = StringUtils.substring(key, 0, 1).toUpperCase() + StringUtils.substring(key, 1);
                Method method = clazz.getMethod("get" + name, new Class[0]);
                Object valueObject = method.invoke(object, new Object[0]);
                if(field.getType() != Date.class) {
                    if(valueObject != null) {
                        json.put(key, valueObject.toString());
                    } else {
                        json.put(key, "");
                    }
                } else if(field.getType() == Date.class) {
                    if(valueObject != null) {
                        Date date = (Date)valueObject;
                        if(date.getYear() <= 0 && date.getDate() <= 0 && date.getMonth() <= 0) {
                            json.put(key, DateFormatUtils.format(date, "HH:mm:ss"));
                        } else if(date.getHours() <= 0 && date.getMinutes() <= 0 && date.getSeconds() <= 0) {
                            json.put(key, DateFormatUtils.format(date, "yyyy-MM-dd"));
                        } else {
                            json.put(key, DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss"));
                        }
                    } else {
                        json.put(key, "");
                    }
                }
            }
        } catch (IllegalArgumentException var13) {
            var13.printStackTrace();
        } catch (IllegalAccessException var14) {
            var14.printStackTrace();
        } catch (NoSuchMethodException var15) {
            var15.printStackTrace();
        } catch (SecurityException var16) {
            var16.printStackTrace();
        } catch (InvocationTargetException var17) {
            var17.printStackTrace();
        }

        return json;
    }

}

