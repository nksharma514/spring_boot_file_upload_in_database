package com.file.uploadbd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.file.uploadbd.method.FileDb;

@Repository
public interface FileDbRepository extends JpaRepository<FileDb, String> {

}
