package com.example.crypto.utils;

import lombok.experimental.UtilityClass;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@UtilityClass
public class StreamTools {

    /**
     * Converts an {@link Iterable} to a {@link Stream}.
     *
     * Example:
     *      public List<CompanyGroup> getCompanyGroups() {
     *          return StreamTools.toStream(companyGroupRepository.findAll())
     *              .map(companyGroupMapper::fromEntity)
     *              .collect(Collectors.toList());
     *      }
     *
     * @param iterable specifies an iterable to convert
     * @param <T>      specifies a type of elements
     * @return a stream of elements
     */
    public static <T> Stream<T> toStream(Iterable<T> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false);
    }
}
