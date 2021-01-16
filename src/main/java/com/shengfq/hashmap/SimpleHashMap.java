package com.shengfq.hashmap;
/**
 * 简单的hashMap实现类
 * @author sheng
 * @date 2020-07-28
 * @copyright shengfq
 * */
public class SimpleHashMap implements ISimpleMap {
    /**
     * 指向哈希表的数组引用
     * */
    public Entry[] table;
    /**
     * 键值对的数量
     * */
    int size;

    public SimpleHashMap() {
        //哈希表主数组默认长度16
        table = new Entry[16];
    }

    /**
     * put存储
     * */
    @Override
    public void put(Object key, Object value) {
        //计算哈希码
        int hash = key.hashCode();
        //根据哈希码计算存储位置
        int index = hash % table.length;
        //或者index = HashCode（Key） & （Length - 1）

        //存入指定位置
        if (table[index] == null) {
            //如果该位置没有元素，增加一个节点
            table[index] = new Entry(hash, key, value);
            size++;
        } else {//如果有元素，进行逐个比较
            Entry entry = table[index];
            //Entry previousEntry = null;
            while (entry != null) {
                //如果找到了相同的key
                if (entry.getKey().equals(key)) {
                    //新的value替代旧的value
                    entry.value = value;
                    return;
                }
                //previousEntry = entry;
                entry = entry.next;
            }
            //循环结束，表明也没有相同的key，在链表最后添加一个节点
            //previousEntry.next = new Entry(hash, key, value);
            //循环结束，表明也没有相同的key，在链表最前边添加一个节点
            Entry firstEntry = table[index];
            table[index] = new Entry(hash, key, value, firstEntry);
            size++;
        }
    }
    /**
     * get获取
     * */
    @Override
    public Object get(Object key) {
        //计算哈希码
        int hash = key.hashCode();
        //根据哈希码计算存储位置
        int index = hash % table.length;
        //查找对应的Entry
        Entry entry = null;
        if (table[index] != null) {
            Entry currentEntry = table[index];
            while (currentEntry != null) {
                if (currentEntry.getKey().equals(key)) {
                    entry = currentEntry;
                    break;
                }
                currentEntry = currentEntry.next;
            }
        }
        return entry == null ? null : entry.getValue();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("{");
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                Entry entry = table[i];
                while (entry != null) {
                    builder.append(entry.getKey() + "=" + entry.getValue() + ",");
                    entry = entry.next;
                }
            }
        }
        if (builder.length() != 1) {
            builder.deleteCharAt(builder.length() - 1);
        }
        builder.append("}");
        return builder.toString();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 移除元素
     *
     * @param key
     **/
    @Override
    public Object remove(Object key) {
        //计算哈希码
        int hash = key.hashCode();
        //根据哈希码计算存储位置
        int index = hash % table.length;
        //查找对应的Entry
        Entry entry = null;
        if (table[index] != null) {
            Entry currentEntry = table[index];
            while (currentEntry != null) {
                if (currentEntry.getKey().equals(key)) {
                    entry = currentEntry;
                    //队列中要删除该元素
                    break;
                }
                currentEntry = currentEntry.next;
            }

        }
        return entry == null ? null : entry.getValue();
    }

    /**
     * 键值对
     * */
    class Entry implements ISimpleMap.Entry {
        //哈希码
        private int hash;
        //键
        private Object key;
        //值
        private Object value;
        //指向下一个节点的指针
        private Entry next;

        public Entry() {
        }

        public Entry(int hash, Object key, Object value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }

        public Entry(int hash, Object key, Object value, Entry next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public Object getKey() {
            return key;
        }
        @Override
        public Object getValue() {
            return value;
        }
        @Override
        public String toString() {
            if (next != null) {
                return "{" + key + ":" + value + "-" + hash + " " + next + "}";
            } else {
                return "{" + key + ":" + value + "-" + hash + "}";
            }
        }
    }
}