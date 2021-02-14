
package lista4;

import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Casa
 */
public class Lista4 {

    
    public static void main(String[] args) 
    {
        //Ordenada Crescescente
        Heap []ordenado_crescente= new Heap[10];
        int tamanho;
        Random aleatorio = new Random();
        System.out.println("Experimento 1:");
        System.out.println("Ordenada Crescente:");
        for(int i=0;i<10;i++)
        {
            tamanho=(i+1)*10000;
            long []heap_tam = new long[tamanho];
            for(int j=1;j<=tamanho;j++)
            {
                heap_tam[j-1]=j;
            }
            ordenado_crescente[i]=new Heap(heap_tam);
            System.out.println("Heap "+(i+1)+"   Troca de posicoes = "+ordenado_crescente[i].getTrocasDePosicoes()+"  Troca posicoes heap = "+ordenado_crescente[i].getTrocaDePosicoes_heap());
        }
        //Ordenado decrescente
        Heap []ordenado_decrescente= new Heap[10];
        System.out.println("");
        System.out.println("Experimento 2 ");
        System.out.println("Ordenada Decrescente:");
        for(int i=0;i<10;i++)
        {
            tamanho=(i+1)*10000;
            long []heap_tam = new long[tamanho];
            for(int j=tamanho;j>0;j--)
            {
                heap_tam[tamanho-j]=j;
            }
            ordenado_decrescente[i]=new Heap(heap_tam);
            System.out.println("Heap "+(i+1)+"   Troca de posicoes = "+ordenado_crescente[i].getTrocasDePosicoes()+"  Troca posicoes heap = "+ordenado_decrescente[i].getTrocaDePosicoes_heap());
        }
        //Aleatorio
        Heap []heap_aleatorio= new Heap[10];
        System.out.println("");
        System.out.println("Experimento 3 ");
        System.out.println("Aleatoria:");
        for(int i=0;i<10;i++)
        {
            tamanho=(i+1)*10000;
            long []vetor_aleatorio=new long[tamanho];
            //preenchendo vetor de 1 a 500000 ordenado
            for(int k=0;k<tamanho;k++)
            {
     
                int random=aleatorio.nextInt(500000);
                //System.out.println(random);
                while(verifica(vetor_aleatorio,k,random)==false)
                {
                    random=aleatorio.nextInt(500000);
        
                }
                vetor_aleatorio[k]=random;
            }
            heap_aleatorio[i]=new Heap(vetor_aleatorio);
            System.out.println("Heap "+(i+1)+"   Troca de posicoes = "+heap_aleatorio[i].getTrocasDePosicoes()+"  Troca posicoes heap = "+heap_aleatorio[i].getTrocaDePosicoes_heap());
        }
    }
    //metodo que verifica se o numero gerado ja esta contido no vetor
    static boolean verifica(long []vet,int tam,int num)
    {
           for(int i=0;i<tam;i++)
           {
               if(vet[i]==num)
               {
                   return false;
               }
           }
           return true;
    }
    
}
