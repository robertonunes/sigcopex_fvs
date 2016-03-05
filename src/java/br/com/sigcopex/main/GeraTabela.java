
package br.com.sigcopex.main;

import br.com.sigcopex.util.HibernateUtil;

public class GeraTabela {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();
        HibernateUtil.getSessionFactory().close();
    }
}
