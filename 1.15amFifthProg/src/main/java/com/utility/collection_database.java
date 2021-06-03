/*package com.utility;


import java.time.LocalDateTime;
import java.util.NavigableSet;
import java.util.ArrayDeque;
import java.util.TreeSet;
import java.util.NavigableSet;
import java.util.Objects;

import  com.collection.Flat;
import com.collection.House;
import exceptions.CollectionIsEmptyException;

public class collection_database {

    public static Object CollectionManager;
    private Object Flat;

    public Object generateNextId() {
    }

    public void addToCollection(com.collection.Flat flatToAdd) {
    }

    public int collectionSize() {
    }

    public Object getFirst() {
    }

    /**
     * Operates the collection itself.

    public static class CollectionManager extends collection_database {
        private  fileManager1 fileManager1;
        private ArrayDeque<Flat> FlatCollection =  new ArrayDeque<>();
        private LocalDateTime lastInitTime;
        private LocalDateTime lastSaveTime;
        private com.utility.fileManager1 fileManager;

        public CollectionManager(fileManager1 fileManager) {
            this.lastInitTime = null;
            this.lastSaveTime = null;
            this.fileManager = fileManager1;

            loadCollection();
        }

        /**
         * @return The collecton itself.

        public NavigableSet<Flat> getCollection() {
            return (NavigableSet<com.collection.Flat>) FlatCollection;
        }

        /**
         * @return Last initialization time or null if there wasn't initialization.

        public LocalDateTime getLastInitTime() {
            return lastInitTime;
        }

        /**
         * @return Last save time or null if there wasn't saving.

        public LocalDateTime getLastSaveTime() {
            return lastSaveTime;
        }

        /**
         * @return Name of the collection's type.

        public String collectionType() {
            return FlatCollection.getClass().getName();
        }

        /**
         * @return Size of the collection.

        public int collectionSize() {
            return FlatCollection.size();
        }

        /**
         * @return The first element of the collection or null if collection is empty.

        public Flat getFirst() {
            if (FlatCollection.isEmpty()) return null;
            return FlatCollection.first();
        }

        /**
         * @return The last element of the collection or null if collection is empty.

        public Flat getLast() {
            if (FlatCollection.isEmpty()) return null;
            return FlatCollection.last();
        }

        /**
         * @param id ID of the marine.
         * @return A marine by his ID or null if marine isn't found.

        public Flat getById(Long id) {
            for (Flat Flatno : FlatCollection) {
                if (Objects.equals(Flatno.getId(), id)) return Flatno;
            }
            return null;
        }


        public Flat getByValue(Flat FlatToFind) {
            for (Flat flatnumm : flatCollection) {
                if (flatnumm.equals(flatnummToFind)) return flatnumm;
            }
            return null;
        }

        /**
         * @return Sum of all marines' health or 0 if collection is empty.

        public double getSumOfHealth() {
            double sumOfgoodhouse = 0;
            for (Flat flatnum : FlatCollection) {
                sumOfgoodhouse += flatnum.getHouse().getNumberOfLifts();
            }
            return sumOfgoodhouse;
        }

        /**
         * @return Marine, who has max melee weapon.
         * @throws CollectionIsEmptyException If collection is empty.



        public String weaponFilteredInfo(House NameToFilter) {
            String info = "";
            for (Flat flatnum : FlatCollection) {
                if (flatnum.getHouse().equals(NameToFilter)) {
                    info += flatnum + "\n\n";
                }
            }
            return info.trim();
        }

        public void addToCollection(Flat flatnum) {
            FlatCollection.add(flatnum);
        }


        public void removeFromCollection(Flat flatnum) {
            FlatCollection.remove(flatnum);
        }


        public void removeGreater(Flat FlatToCompare) {
            FlatCollection.removeIf(marine -> marine.compareTo(FlatToCompare) > 0);
        }

        /**
         * Clears the collection.

        public void clearCollection() {
            FlatCollection.clear();
        }

        /**
         * Generates next ID. It will be (the bigger one + 1).
         * @return Next ID.

        public Long generateNextId() {
            if (FlatCollection.isEmpty()) return 1L;
            return FlatCollection.last().getId() + 1;
        }

        /**
         * Saves the collection to file.
        public void saveCollection() {
            fileManager.writeCollection(FlatCollection);
            lastSaveTime = LocalDateTime.now();
        }

        /**
         * Loads the collection from file.

        private void loadCollection() {
            FlatCollection = (ArrayDeque<com.collection.Flat>) fileManager.readCollection();
            lastInitTime = LocalDateTime.now();
        }

        @Override
        public String toString() {
            if (FlatCollection.isEmpty()) return "Коллекция пуста!";

            String info = "";
            for (Flat flat : FlatCollection) {
                info += flat;
                if (flat != FlatCollection.last()) info += "\n\n";
            }
            return info;
        }
    }
}

*/