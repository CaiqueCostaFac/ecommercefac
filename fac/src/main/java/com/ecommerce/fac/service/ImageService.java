package com.ecommerce.fac.service;

import com.ecommerce.fac.model.Image;
import com.ecommerce.fac.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public List<Image> buscarImagensPorProdutoId(Long produtoId) {
        return imageRepository.findByProdutoId(produtoId);
    }
}
