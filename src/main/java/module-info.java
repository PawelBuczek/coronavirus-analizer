module pl.sdacademy {
    requires javafx.controls;
    requires com.google.gson;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires net.bytebuddy;
    requires java.naming;
    requires java.xml.bind;
    requires com.sun.xml.bind;
    requires com.fasterxml.classmate;
    requires mysql.connector.java;
    exports pl.sdacademy.javaFX;
    exports pl.sdacademy.coronavirus;
}
