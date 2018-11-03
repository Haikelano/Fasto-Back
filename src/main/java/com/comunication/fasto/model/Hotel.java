package com.comunication.fasto.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "hotel")
public class Hotel {
        @Id
        private String id;
        private String name;
        private int nombre;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getNombre() {
            return nombre;
        }

        public void setNombre(int nombre) {
            this.nombre = nombre;
        }

        public Hotel(String id, String name, int nombre) {
            this.id = id;
            this.name = name;
            this.nombre = nombre;
        }
        public Hotel() {}
        @Override
        public String toString() {
            return "hotel{" +
                    "id=" + id +
                    ", name=" + name +
                    ", nombre=" + nombre +
                    '}';
        }
    }

