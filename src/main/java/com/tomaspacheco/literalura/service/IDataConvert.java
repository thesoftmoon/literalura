package com.tomaspacheco.literalura.service;

public interface IDataConvert {
    //<T> is generic type of data
    <T> T getData(String json, Class<T> clase);
}
