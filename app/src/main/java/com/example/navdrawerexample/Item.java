package com.example.navdrawerexample;

public class Item {
        private String image;
        private String Title;
        private String Description;

        public Item(String image, String title, String description) {
            this.image = image;
            this.Title = title;
            this.Description = description;
        }

        public String getImage() {
            return image;
        }

        public String getTitle() {
            return Title;
        }

        public String getDescription() {
            return Description;
        }
    }

