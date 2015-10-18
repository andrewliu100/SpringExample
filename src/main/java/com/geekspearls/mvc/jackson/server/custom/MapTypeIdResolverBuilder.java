/**
 * COPYRIGHT (C) 2015 Andrew Liu. All Rights Reserved.
 * <p>
 * SpringDemo com.geekspearls.mvc.jackson.server.custom.MapTypeIdResolverBuilder
 *
 * @author Andrew Liu
 * @since 2015 2/10/2015 8:44 PM
 */
package com.geekspearls.mvc.jackson.server.custom;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.jsontype.*;
import com.fasterxml.jackson.databind.jsontype.impl.StdTypeResolverBuilder;

import java.util.Collection;
import java.util.HashMap;

/**
 * This is a customized TypeIdResolverBuilder to de/serialize the Map type object dynamically. The type information
 * of the Map instance will be retained in the JSON message after serialization and the Map object will be deserialized
 * to the actually Map type instead of the default LinkedHashMap provided by Jackson 2.
 *
 * @author Andrew
 */
public class MapTypeIdResolverBuilder extends StdTypeResolverBuilder {

    public MapTypeIdResolverBuilder() {
    }

    @Override
    public TypeDeserializer buildTypeDeserializer(DeserializationConfig config,
                                                  JavaType baseType, Collection<NamedType> subtypes) {
        return useForType(baseType) ? super.buildTypeDeserializer(config, baseType, subtypes) : null;
    }

    @Override
    public TypeSerializer buildTypeSerializer(SerializationConfig config,
                                              JavaType baseType, Collection<NamedType> subtypes) {
        return useForType(baseType) ? super.buildTypeSerializer(config, baseType, subtypes) : null;
    }

    /**
     * Method called to check if the default type handler should be
     * used for given type.
     * Note: "natural types" (String, Boolean, Integer, Double) will never
     * use typing; that is both due to them being concrete and final,
     * and since actual serializers and deserializers will also ignore any
     * attempts to enforce typing.
     */
    public boolean useForType(JavaType t) {
        return t.isMapLikeType() || t.isJavaLangObject();
    }
}
