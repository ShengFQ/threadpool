package demo.shengfq.algorithm;
/**
 * 排序算法
 * 我比较熟悉的是插入排序和选址排序
 * */
public class SortAlgorithm {
    int count_compare=0;
    int count_move=0;
    int count_all(){
        return count_compare+count_move;
    }

    void clear_count(){
        count_compare=0;
        count_move=0;
    }
	public static void main(String[] args) {
		int[] ab=new int[]{5,3,1,4};
		insert(ab);
		for(int i=0;i<ab.length;i++){
			System.out.print(ab[i]+" ");
		}
	}


    //insert sort
    void insert_element(int a[],int size,int element){
        int i=0;
        for(i=size-1;i>=0;i--){
            count_compare++;
            if(element<a[i]) {
                a[i + 1] = a[i];
                count_move++;
            }else{
                    break;
                }
        }
        a[i+1]=element;
        count_move++;
    }

    void insertSort(int a[] ,int size){
        for(int i=1;i<size;i++){
            insert_element(a,i,a[i]);
        }
    }

    void merge(int c[],int d[],int l,int m,int r){
        int i=l,j=m+1,k=l;
        while(i<=m&& j<=r){
            count_compare++;
            if(c[i]<=c[j]){
                d[k++]=c[i++];
                count_move++;
            }else{
                d[k++]=c[j++];
                count_move++;
            }
        }
        count_compare++;
        if(i>m){
            for(int q=j;q<=r;q++){
                d[k++]=c[q];
                count_move++;
            }
        }else{
            for(int q=i;q<=m;q++){
                d[k++]=c[q];
                count_move++;
            }
        }
    }

    void copy(int a[],int b[],int l,int r){
        for(int i=l;i<=r;i++){
            a[i]=b[i];
            count_move++;
        }
    }

    void mergeSort(int a[],int left,int right,int size){
        if(left<right){
            count_compare++;
            int i=(right+left)/2;
            int p=size;
            int[] b=new int[p];
            mergeSort(a,left,i,size);
            mergeSort(a,i+1,right,size);
            merge(a,b,left,i,right);
            copy(a,b,left,right);
        }
    }

    //quick sort
    void swap(int a[],int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
        count_move+=3;

    }

    int partition(int a[],int p,int r){
        int i=p,j=r+1;
        int x=a[p];
        while(true){
            while(a[++i]<x && i<r) {count_compare++;}
            while(a[--j]>x){count_compare++;}
            count_compare++;
            if(i>=j){break;}
            swap(a,i,j);
        }
        a[p]=a[j];
        a[j]=x;
        count_move++;
        return j;
    }

    void quickSort(int a[] ,int p,int r){
        if(p<r){
            int q=partition(a,p,r);
            quickSort(a,p,q-1);
            quickSort(a,q+1,r);
        }
        count_compare++;
    }

    void show_array(int a[],int size){
        for(int i=0;i<size;i++){
            System.out.print(a[i]);
        }
    }


	/**
	 * 插入排序
	 * */
	public static void insert(int[] array){
		//原理 插入一个新的元素放最后,移动集合让出最小的索引空位,将元素放入最小
		for(int i=1;i<array.length;i++){
			int current=array[i];
			int k;
			for(k=i-1;k>=0&&array[k]>current;k--){
				array[k+1]=array[k];
			}
			
			array[k+1]=current;
		}
	}
	/**
	 * 选择排序
	 * */
	public static void Select(int[] array){
		//选择排序的原理是将数组范围从左至右逐渐减一,选择最小的数与第一个元素进行交换,循环往复,最终只剩下最后一个元素
		for(int i=0;i<array.length-1;i++){
			int minist=array[i];
			int minindex=i;
			//走一波看看
			for(int j=i+1;j<array.length;j++){
				if(array[j]<minist){
					//交换
					minist=array[j];
					minindex=j;
				}
			}
			//minist最小,赋值给这轮第一个
			if(minindex!=i){
			array[minindex]=array[i];
			array[i]=minist;
			}
			
		}
	}
	
	public static void maopao(int array){
		//冒泡排序的原理,每一轮循环从当前集合中末尾与前一个比较,只要比前一个小,就交换,这样每一轮都能产生将最小的泡上浮
		
	}
}
