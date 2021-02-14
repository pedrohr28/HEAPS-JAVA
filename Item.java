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
public class Item 
{
    private long chave ;
    public Item ( long chave ) 
    {
        this . chave = chave ;
    }
    public long compara (long it, long aux) 
    {
        Item item = new Item(it);
        if ( item.chave < aux )
            return -1;
        else if ( item.chave > aux )
            return 1;
        return 0;
    }
    public long getChave () 
    {
        return this.chave ;
    }
    public void setChave(long chave_aux)
    {
        this.chave=chave_aux;
    }
}

    

