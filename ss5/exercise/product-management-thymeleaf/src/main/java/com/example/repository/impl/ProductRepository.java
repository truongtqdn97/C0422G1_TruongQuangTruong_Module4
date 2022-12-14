package com.example.repository.impl;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private static final String SELECT_ALL = "select p from Product p";
    private static final String SELECT = "select p from Product p where p.pName like :pName";

    @Override
    public List<Product> showProductList(String pName) {
        TypedQuery<Product> productTypedQuery =
                BaseRepository.entityManager.createQuery(SELECT_ALL, Product.class);
//        List<Product> productList = new ArrayList<>();
        if (pName==null){
            return productTypedQuery.getResultList();
        }else {
            productTypedQuery = BaseRepository.entityManager.createQuery(SELECT, Product.class);
            productTypedQuery.setParameter("pName", "%"+pName+"%");
            return productTypedQuery.getResultList();
        }
    }

    @Override
    public void save(Product product) {
        EntityTransaction entityTransaction =
                BaseRepository.entityManager.getTransaction();

        entityTransaction.begin();

        BaseRepository.entityManager.persist(product);

        entityTransaction.commit();
    }

    @Override
    public void remove(int pId) {
        EntityTransaction entityTransaction =
                BaseRepository.entityManager.getTransaction();

        entityTransaction.begin();

        BaseRepository.entityManager.remove(this.findById(pId));

        entityTransaction.commit();
    }

    @Override
    public void update(Product product) {
        EntityTransaction entityTransaction =
                BaseRepository.entityManager.getTransaction();

        entityTransaction.begin();

        BaseRepository.entityManager.merge(product);

        entityTransaction.commit();
    }

    @Override
    public Product findById(int pId) {
        return BaseRepository.entityManager.find(Product.class, pId);
    }

}
