package com.motor.common.helpers;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Properties;

public class SqlQueriesXmlFileReader {

    private final String xmlFileName;
    private Properties sqlQueries;

    protected SqlQueriesXmlFileReader(String xmlFileName) {
        this.xmlFileName = xmlFileName;
    }

    @PostConstruct
    public void init() throws IOException {
        sqlQueries = readSqlQueries(xmlFileName);
    }

    protected String getSqlQuery(String queryName) {
        return sqlQueries.getProperty(queryName);
    }

    private Properties readSqlQueries(String sqlQueriesXMLFileName) throws IOException {
        Resource queriesResource = new ClassPathResource(sqlQueriesXMLFileName);
        System.out.println("queriesResource: "+queriesResource.getURL().toString());
        Properties properties = new Properties();
        properties.loadFromXML(queriesResource.getInputStream());
        return properties;
    }

}
