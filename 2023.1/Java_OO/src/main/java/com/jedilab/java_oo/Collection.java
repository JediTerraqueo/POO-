package com.jedilab.java_oo;

public interface Collection {
    /**
     * Adiciona um valor à coleção.
     *
     * @param value o valor a ser adicionado à coleção
     */
    void add(int value);

    /**
     * Remove a primeira ocorrência do valor especificado da coleção, se estiver presente.
     *
     * @param value o valor a ser removido da coleção, se estiver presente
     */
    void remove(int value);

    /**
     * Verifica se a coleção contém o valor especificado.
     *
     * @param value o valor a ser verificado se está contido na coleção
     * @return true se a coleção contém o valor especificado, false caso contrário
     */
    boolean contains(int value);

    /**
     * Converte a coleção em um array de inteiros.
     *
     * @return um array de inteiros contendo todos os elementos da coleção
     */
    int[] toArray();
}
