package com.volkodav4ik;

import java.util.Comparator;

public class MyTreeMap implements MyMap, Comparator<String> {


    public class Entry {

        String key;
        String value;
        Entry left;
        Entry right;
        Entry parent;

        public Entry(String key, String value, Entry parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
        }
    }

    private Entry root;
    private int size = 0;

    public MyTreeMap() {
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return size;
    }


    @Override
    public String put(String key, String value) {
        if (key == null) {
            throw new NullPointerException();
        }
        if (size() == 0) {
            root = new Entry(key, value, null);
            size = 1;
            return null;
        }
        if (containsKey(key)) {
            Entry currentEntry = getEntry(key);
            String oldValue = currentEntry.value;
            currentEntry.value = value;
            return oldValue;
        } else {
            Entry p = root;
            int cmp;
            Entry parent;
            do {
                parent = p;
                cmp = key.compareTo(p.key);
                if (cmp < 0) {
                    p = p.left;
                } else {
                    p = p.right;
                }
            } while (p != null);
            Entry newEntry = new Entry(key, value, parent);
            if (cmp < 0) {
                parent.left = newEntry;
            } else {
                parent.right = newEntry;
            }
            size++;
            return null;
        }
    }

    @Override
    public boolean containsKey(String key) {
        return getEntry(key) != null;
    }

    @Override
    public String get(String key) {
        if (key != null){
            return getEntry(key).value;
        } else {
            throw new NullPointerException();
        }
    }

    @Override
    public boolean containsValue(String value) {
        for (Entry e = getFirstEntry(); e != null; e = successor(e))
            if (value.equalsIgnoreCase(e.value))
                return true;
        return false;

    }

    private Entry getEntry(String key) {
        if (key == null) {
            throw new NullPointerException();
        }
        Entry p = root;
        while (p != null) {
            int cmp = key.compareTo(p.key);
            if (cmp < 0) {
                p = p.left;
            } else {
                if (cmp > 0) {
                    p = p.right;
                } else {
                    return p;
                }
            }
        }
        return null;
    }

    final Entry getFirstEntry() {
        Entry p = root;
        if (p != null)
            while (p.left != null)
                p = p.left;
        return p;
    }

    static Entry successor(Entry t) {
        if (t == null)
            return null;
        else if (t.right != null) {
            Entry p = t.right;
            while (p.left != null)
                p = p.left;
            return p;
        } else {
            Entry p = t.parent;
            Entry ch = t;
            while (p != null && ch == p.right) {
                ch = p;
                p = p.parent;
            }
            return p;
        }
    }


    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }

    public String toString() {
        return printTree(root);
    }

    private String printTree(Entry tree) {
        if (tree == null) {
            return "-";
        }
        String leftTree = printTree(tree.left);
        String rightTree = printTree(tree.right);
        return "(" + leftTree + tree.value + rightTree + ")";
    }
}
