package com.gcu.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.ProductEntity;
import com.gcu.data.entity.UserEntity;
import com.gcu.repositories.ProductRepository;
import com.gcu.repositories.UserRepository;

@Service
public class ProductsDataService implements DataAccessInterface<ProductEntity> {

	@Autowired
	private ProductRepository productsRepository;

	public ProductsDataService(ProductRepository productsRepository) {
		this.productsRepository = productsRepository;
	}

	@Override
	public List<ProductEntity> findAll() {
		List<ProductEntity> products = new ArrayList<ProductEntity>();

		try {
			Iterable<ProductEntity> productsIterable = productsRepository.findAll();

			products = new ArrayList<ProductEntity>();
			productsIterable.forEach(products::add);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return products;
	}

	public boolean create(ProductEntity product) {
		try {
			this.productsRepository.save(product);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public ProductEntity findById(Long id) {
	    return productsRepository.findById(id).orElse(null);
	}
	
    @Override
    public boolean update(ProductEntity product) {
        try {
            if (productsRepository.existsById(product.getProductID())) {
                productsRepository.save(product);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

	public void deleteProductsByIds(List<Long> productIds) {
		try {
			productsRepository.deleteAllById(productIds);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean delete(ProductEntity t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ProductEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductEntity findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
