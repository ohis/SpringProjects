package com.codingdojo.crud.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.crud.models.Langs;

public interface LangRepository extends CrudRepository<Langs, Long> {
  List<Langs> findAll();
}
