package tech.zeta.practice.generics;

public class ExcerciseB {
        class Pair<K,V>{
            K key;
            V value;

            public Pair(K key,V value){
                this.key = key;
                this.value = value;
            }

            Pair<V,K> swap(){
                return new Pair<V,K>(value,key);
            }

            @Override
            public String toString() {
                return "Key: "+key+" Value: "+value;
            }
        }

         void one(){
             Pair<Integer,String> pair = new Pair<>(1,"One");
             System.out.println(pair);

             System.out.println("After swapping");
             System.out.println(pair.swap());
         }

        public static void main(String[] args) {
            ExcerciseB object = new ExcerciseB();
            object.one();
        }

}
