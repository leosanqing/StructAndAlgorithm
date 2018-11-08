public  class MyList {
     int data[];
     int length;
     int maxSize;//最大容量

     MyList myList;



    public void initList(int size){
        this.maxSize=size;
        this.length=0;
        this.data=new int [maxSize];
    }

    public int getElem(int location) throws Exception {
        if(location<1||location>this.length){
            throw new Exception("超出范围");
        }
        return data[location-1];
    }

    public boolean insert(int location,int elem) throws Exception {
        if(maxSize==length)
            throw new Exception("已经满栈，不能再添加");
        if(location<1||location>this.maxSize){
            throw new Exception("超出范围");
        }
        data[location-1]=elem;
        length++;
        return true;
    }

    public int del(int location) throws Exception {
        if(length==0){
            throw new Exception("表中已经没有元素，不能删除");
        }
        if(location<1||location>this.length){
            throw new Exception("超出范围");
        }
        int elem=data[location-1];

        if(location<length){
            for(int k=location;k<length;k++){
                data[k-1]=data[k];
            }
        }
        length--;
        return elem;
    }



}
