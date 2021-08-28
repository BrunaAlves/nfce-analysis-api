package com.nfceanalysis.api.service;

import com.nfceanalysis.api.model.Discount;
import com.nfceanalysis.api.repository.DiscountRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DiscountService {

    @Autowired
    DiscountRepository discountRepository;

    public Discount findById(String id){
        return discountRepository.findById(new ObjectId(id))
                .orElseThrow(() -> new NoSuchElementException("Discount Not Found for id: " + id));
    }

    public List<Discount> findByUserId(String userId){
        return discountRepository.findByUserId(new ObjectId(userId))
                .orElseThrow(() -> new NoSuchElementException("Discount Not Found for id: " + userId));
    }

    public List<Discount> findByItemId(String itemId){
        return discountRepository.findByItemId(new ObjectId(itemId))
                .orElseThrow(() -> new NoSuchElementException("Discount Not Found for id: " + itemId));
    }

    public Discount create(Discount discount){
        return discountRepository.save(discount);
    }

    public Discount update(Discount discount){
        return discountRepository.save(discount);
    }

    public String delete(String id){
        discountRepository.deleteById(id);
        return "Successfully delete discount with id: " + id;
    }
}