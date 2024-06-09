package com.example.personaddress.model.convertor;

import java.util.List;
import java.util.stream.Collectors;

public interface AbstractConvertor<E, RQ, RP> {

    E convertToEntity(RQ entity);

    RP convertToResponse(E entity);

    default List<RP> entityCollectionConvertor(List<E> eList) {
        if (eList != null){
            return eList.stream().map(i->{
                try{
                    return convertToResponse(i);
                }catch (Exception e){
                    throw new RuntimeException(e);
                }
            }).collect(Collectors.toList());
        }
        return null;
    }

    default List<E> requestCollectionConvertor(List<RQ> dList) {

        if (dList != null) {
            return dList.stream().map(i -> {
                try {
                    return convertToEntity(i);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }).collect(Collectors.toList());

        }
        return null;
    }

}

