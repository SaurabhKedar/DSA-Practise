//Advanced DSA 3: Backtracking & Advanced Trees
// Lecture 11 | DSA: Hashing 3: Internal Implementation & Problems

import java.util.LinkedList;

public class CustomHashMap<K, V> {
    class Node{
        K key;
        V value;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    LinkedList<Node>[] buckets;
    int currSize;

    public CustomHashMap(){
        init(10);
        currSize = 0;
    }

    public void put(K key, V value){
        int idx = hash(key); // get the index
        LinkedList<Node> curr = buckets[idx]; // get the current linkedlist
        for (Node node : curr){
            if (node.key.equals(key)){ // check of the value already exists
                node.value = value; // update the value
                return;
            }
        }
        curr.add(new Node(key, value)); // Add the value at the last if the key was not present
        currSize++;

        double lambda = (double) currSize / buckets.length;

        if (lambda  > 0.75){
            reHash();
        }
    }

    public V get(K key){
        int idx = hash(key); // get the index
        LinkedList<Node> curr = buckets[idx]; // get the current linkedlist
        for (Node node : curr){
            if (node.key.equals(key)){ // check of the value already exists
                return node.value; // return the node value
            }
        }
        return null;
    }

    public V remove(K key){
        int idx = hash(key); // get the index
        LinkedList<Node> curr = buckets[idx]; // get the current linkedlist
        for (int i = 0; i < curr.size(); i++){
            Node node = curr.get(i);
            if (node.key.equals(key)){
                V value = node.value;
                curr.remove(i);
                currSize--;
                return value;
            }
        }
        return null;
    }

    public boolean containsKey(K key){
        int idx = hash(key); // get the index
        LinkedList<Node> curr = buckets[idx]; // get the current linkedlist
        for (Node node : curr){
            if (node.key.equals(key)){
                return true;
            }
        }
        return false;
    }

    public int getSize(){
        return currSize;
    }

    public int hash(K key){
        int hc = key.hashCode();
        return hc % buckets.length;
    }

    public void reHash(){
        LinkedList<Node>[] oldBuckets = buckets;
        init(oldBuckets.length * 2);
        for (int i = 0; i < oldBuckets.length; i++){
            LinkedList<Node> curr = oldBuckets[i];
            for (Node node : curr){
                put(node.key, node.value);
            }
        }
    }

    public void init(int size){
        buckets = new LinkedList[size];
        for (int i = 0; i < 10; i++){
            buckets[i] = new LinkedList<>();
        }
    }
}

// lambda = currentSize / size of the array
