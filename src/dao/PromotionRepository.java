package dao;

import model.Promotion;

import java.util.ArrayList;
import java.util.List;

public class PromotionRepository implements CrudRepository<Promotion,String>{

    private static List<Promotion> promotionList = new ArrayList<>();

    @Override
    public Promotion save(Promotion entity) {
        promotionList.add(entity);
        return entity;
    }

    @Override
    public Promotion findOne(String primaryKey) {
        for (Promotion promotion : promotionList){
            if(primaryKey.equals(promotion.getId())){
                return promotion;
            }
        }
        return null;
    }

    @Override
    public List<Promotion> findAll() {
        return promotionList;
    }

    @Override
    public Integer count() {
        return promotionList.size();
    }

    @Override
    public void delete(String primaryKey) {
        promotionList.removeIf(s -> primaryKey.equals(s.getId()));
    }

    @Override
    public boolean exists(String primaryKey) {
        if(null != findOne(primaryKey)){
            return true;
        }
        return false;
    }
}
