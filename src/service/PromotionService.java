package service;

import dao.PromotionRepository;
import model.Promotion;

import java.util.List;

public class PromotionService {
    private final PromotionRepository promotionRepository;

    public PromotionService(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    public List<Promotion> getPromotions() {
        return promotionRepository.findAll();
    }

    public Promotion createPromotion(Promotion promotion){
        if(promotionRepository.exists(promotion.getId())){
            System.out.println("Promotion is exists");
            return null;
        }
        promotionRepository.save(promotion);
        return promotion;
    }

    public Promotion getPromotionById(String id){
        return promotionRepository.findOne(id);
    }

    public void removePromotion(String id){
        promotionRepository.delete(id);
    }

}
