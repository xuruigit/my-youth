package com.xurui.youth.util;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author XuRui
 * @date 2019/10/10
 */
public class ConvertUtil {

    private ConvertUtil(){

    }

    public static <T> T convert(Object source, Class<T> targetClass) {
        try {
            if(source == null){
                return null;
            }
            T doObj = targetClass.newInstance();
            BeanUtils.copyProperties(source, doObj);
            return doObj;
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public static <T,S> List<T> converts(List<S> sources, Class<T> targetClass) {
        if (CollectionUtils.isEmpty(sources)) {
            return Lists.newArrayList();
        }

        List<T> dos = Lists.newArrayListWithExpectedSize(sources.size());
        sources.forEach(obj ->
                dos.add(convert(obj, targetClass))
        );
        return dos;
    }
}
