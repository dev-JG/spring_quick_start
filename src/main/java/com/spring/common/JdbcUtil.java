package com.spring.common;

import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;

@Log4j2
public class JdbcUtil {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://192.168.153.128:3306/spring?characterEncoding=UTF-8&serverTimezone=UTC", "devtest", "devtest123");
        } catch (Exception e) {
            log.error("##### JdbcUtil::getConnection error={}", e);
        }
        return null;
    }

    public static void close(PreparedStatement statement, Connection connection) {
        if (Objects.nonNull(statement)) {
            try {
                if (!statement.isClosed()) {
                    statement.close();
                }
            } catch (Exception e) {
                log.error("##### JdbcUtil::close error={}", e);
            } finally {
                statement = null;
            }
        }

        if (Objects.nonNull(connection)) {
            try {
                if (!connection.isClosed()) {
                    connection.close();
                }
            } catch (Exception e) {
                log.error("##### JdbcUtil::close error={}", e);
            } finally {
                connection = null;
            }
        }
    }

    public static void close(ResultSet resultSet, PreparedStatement statement, Connection connection) {
        if (Objects.nonNull(resultSet)) {
            try {
                if (!resultSet.isClosed()) {
                    resultSet.close();
                }
            } catch (Exception e) {
                log.error("##### JdbcUtil::close error={}", e);
            } finally {
                resultSet = null;
            }
        }

        if (Objects.nonNull(statement)) {
            try {
                if (!statement.isClosed()) {
                    statement.close();
                }
            } catch (Exception e) {
                log.error("##### JdbcUtil::close error={}", e);
            } finally {
                statement = null;
            }
        }

        if (Objects.nonNull(connection)) {
            try {
                if (!connection.isClosed()) {
                    connection.close();
                }
            } catch (Exception e) {
                log.error("##### JdbcUtil::close error={}", e);
            } finally {
                connection = null;
            }
        }
    }
}