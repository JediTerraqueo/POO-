package com.mycompany.p1_observer;

import java.util.List;

interface Observer {
    void update(String numeroPedido, List<String[]> itensPedido);
}
