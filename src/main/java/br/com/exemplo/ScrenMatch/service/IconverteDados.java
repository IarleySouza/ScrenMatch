package br.com.exemplo.ScrenMatch.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface IconverteDados {

       <T> T obterDados(String json, Class<T> classe) throws JsonProcessingException;
}
