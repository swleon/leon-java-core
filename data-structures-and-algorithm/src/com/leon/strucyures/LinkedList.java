package com.leon.strucyures;

/**
 * 链表
 * @package: com.leon.strucyures
 * @author: 陈明磊<swchenminglei@163.com>
 * @date: 2018/8/15 16:09
 * @ModificarionHistory who     when   what
 * --------------|------------------|--------------
 */
public class LinkedList<E> {

    /**
     * 私有 Node
     */
    private class Node{
        public E e;
        Node next;

        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e,null);
        }

        public Node(){
            this(null, null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList(){
        //初始化一个虚拟头节点
        dummyHead = new Node(null,null);
        size = 0;
    }

    /**
     * 获取链表长度
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断链表是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 在链表头添加新的元素 e
     * @param e
     */
    public void addFirst(E e){
       /* Node node = new Node(e);
        node.next = head;
        head = node;*/

       /* head = new Node(e,head);
        size ++;*/

       add(0, e);
    }

    /**
     * 在链表中的index（0-based）位置添加新元素 e
     * @param index
     * @param e
     */
    public void add(int index, E e){

        if(index < 0 || index > size){
            try {
                throw new IllegalAccessException(" Add failed. Illegal index.");
            } catch (IllegalAccessException e1) {
                e1.printStackTrace();
            }
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

       /* Node node = new Node(e);
        node.next = prev.next;
        prev.next = node;*/

        prev.next = new Node(e, prev.next);
        size ++;
    }

    /**
     * 在链表末尾添加新的元素 e
     * @param e
     */
    public void addLast(E e){
        add(size,e);
    }

    /**
     * 获取链表 第index个位置的元素
     * @param index
     * @return
     */
    public E get(int index){

        if(index < 0 || index > size){
            try {
                throw new IllegalAccessException(" Get failed. Illegal index.");
            } catch (IllegalAccessException e1) {
                e1.printStackTrace();
            }
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        return cur.e;
    }

    /**
     * 获取链表的第一个元素
     * @return
     */
    public E getFirst(){

        return get(0);
    }

    /**
     * 获取链表的最后一个元素
     * @return
     */
    public E getLast(){

        return get(size - 1);
    }

    /**
     * 修改链表的第index个位置的元素e
     * @param index
     * @param e
     */
    public void set(int index,E e){
        if(index < 0 || index > size){
            try {
                throw new IllegalAccessException(" Set failed. Illegal index.");
            } catch (IllegalAccessException e1) {
                e1.printStackTrace();
            }
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 查找链表中是否有元素e
     * @param e
     * @return
     */
    public boolean Contains(E e) {

        Node cur = dummyHead.next;
        while (cur != null){
            if(cur.e.equals(e)){
                return true;
            }else{
                cur = cur.next;
            }
        }
        return false;
    }
}
