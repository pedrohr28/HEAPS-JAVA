/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista4;

/**
 *
 * @author Casa
 */
public class Heap 
{
    private final long[] heap;
    private int n;
    private int trocasDePosicoes;
    private Item aux;
    private int trocaposicoes_heap;
    
    public Heap(long[] h) 
    { //método construtor
        this.heap = h; 
        this.n = this.heap.length - 1;
        //this.heapOrdenado = new int[h.length];
        this.trocasDePosicoes=0;
        this.aux=new Item(n);
        heapsort();
    }

    //Metodo para construir o heap.
    private void contrucaoHeap()
    {
        //transforma um vetor qualquer em um heap
        int noAtual = this.n/2 + 1;
     
        while(noAtual > 1)//O método refaz é invocado até o primeiro elemento.
        {
            noAtual--;
            this.manutencaoHeap(noAtual, this.n);
           
        }
    }
    

     //Metodo para refazer o heap. Ajusta a posição esq do heap passada por parâmetro. O parâmetro corresponde a última posição do vetor
    private void manutencaoHeap(int noAtual, int tamanhoHeap)
    { //refaz
        //restaura as propriedades de um heap sempre que necessário
        int pos2_heap = noAtual*2;
        long aux2 = this.heap[noAtual];
        while(pos2_heap<=tamanhoHeap)
        {
            // pos2_heap se refere ao maior elemento, verificando se é uma posição válida
            //e qual dos filhos de pos2_heap é menor
            if((pos2_heap<tamanhoHeap)&&(this.aux.compara(this.heap[pos2_heap],this.heap[pos2_heap+1])<0)) //Verifica se é uma posição válida e qual dos filhos de j é menor (esq ou dir). J se refere ao maior elemento.
                pos2_heap++;
         
            //verifica se o valor na posição corrente aux2 é maior que seu maior filho no heap pos2_heap
            if(aux.compara(aux2, this.heap[pos2_heap])>=0)
                break;
             
            //se não for maior a troca é realizada
            this.heap[noAtual] = this.heap[pos2_heap];// Se não for maior a troca é realizada.
            noAtual = pos2_heap;
            pos2_heap = noAtual*2;
            this.trocasDePosicoes++;
        }
        this.heap[noAtual]=aux2;
    }
    
    private long retiraMaximo(int tamanhoHeap) throws Exception
    {
        //remove o registro de maior valor do heap e o reorganiza
        long maximo;
        if(this.n < 1)
        {
            throw new Exception ("Erro: heap vazio");
        }
        else
        {
            maximo = this.heap[1];
            this.heap[1] = this.heap[this.n--];
            manutencaoHeap(1,this.n);
        }
        return maximo;
    }
    
    public void heapsort()
    { 
        //implementa o algoritmo de ordenação heapsort
        int tamanhoHeap = this.n;
        this.trocasDePosicoes=0;
        this.trocaposicoes_heap=0;
        contrucaoHeap();
        while(tamanhoHeap>1)
        {
            this.trocaposicoes_heap++;
            long x = this.heap[1];
            this.heap[1] = this.heap[tamanhoHeap];
            this.heap[tamanhoHeap] = x;
            tamanhoHeap--;
            manutencaoHeap(1,tamanhoHeap);
        } 
        //this.trocaposicoes_heap=this.trocasDePosicoes/this.trocaposicoes_heap;
        
    }
    //retorna a Heap
    public long[] getHeap()
    {
        return this.heap;
    }
    //retorna numero de troca de posições da Heap
    public int getTrocaDePosicoes_heap()
    {
        return this.trocaposicoes_heap;
    }
     //retorna numero de troca de posições da HeapSort
    public int getTrocasDePosicoes()
    {
        return this.trocasDePosicoes;
    }
    //retorna o tamanho da heap
    public int getTamanhoHeap()
    {
        return this.heap.length;
    }
    
}
