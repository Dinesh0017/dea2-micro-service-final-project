package com.wms.inventory_management_service.service;

import com.wms.inventory_management_service.exception.ResourceNotFoundException;
import com.wms.inventory_management_service.exception.ServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductCatalogClient {

    private static final String PRODUCT_CATALOG_BASE_URL = "http://product-catalog-service/api/products";

    private final RestClient.Builder restClientBuilder;

    public ProductCatalogProduct getProductById(UUID productId) {
        try {
            return restClientBuilder.build()
                    .get()
                    .uri(PRODUCT_CATALOG_BASE_URL + "/{id}", productId)
                    .retrieve()
                    .body(ProductCatalogProduct.class);
        } catch (HttpClientErrorException.NotFound ex) {
            throw new ResourceNotFoundException("Product", "productId", productId);
        } catch (RestClientException ex) {
            throw new ServiceException("Unable to fetch product details from Product Catalog Service", ex);
        }
    }

    public record ProductCatalogProduct(UUID id, String name, Boolean active) {
    }
}
