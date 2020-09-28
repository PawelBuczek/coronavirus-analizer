module pl.sdacademy.javaFx {
    requires javafx.controls;
    requires com.google.gson;
    requires java.persistence;
    requires org.hibernate.orm.core;
    exports pl.sdacademy.javaFX;
    exports pl.sdacademy.coronavirus;
    requires java.naming;
}