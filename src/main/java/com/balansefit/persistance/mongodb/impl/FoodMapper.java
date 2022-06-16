package com.balansefit.persistance.mongodb.impl;

import com.balansefit.dto.FoodDTO;
import com.balansefit.persistance.mongodb.AbstractMongoDBComon;
import com.balansefit.persistance.mongodb.IFoodMapper;
import com.balansefit.util.CmmUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Slf4j
@Component("FoodMapper")
public class FoodMapper extends AbstractMongoDBComon implements IFoodMapper {

    @Override
    public int insertFood(List<FoodDTO> fList, String colNm) throws Exception {

        log.info(this.getClass().getName() + ".insertFood Start!");

        int res = 0;

        if (fList == null) {
            fList = new LinkedList<>();
        }

        // 데이터를 저장할 컬렉션 생성
        super.createCollection(colNm, "collectTime");

        // 저장할 컬렉션 객체 생성
        MongoCollection<Document> col = mongodb.getCollection(colNm);

        for (FoodDTO fDTO : fList) {
            if (fDTO == null) {
                fDTO = new FoodDTO();

            }

            //레코드 한개씩 저장하기
            col.insertOne(new Document(new ObjectMapper().convertValue(fDTO, Map.class)));

        }

        res = 1;

        log.info(this.getClass().getName() + ".insertFood End!");

        return res;
    }

    @Override
    public List<FoodDTO> getFoodList(String colNm) throws Exception {

        log.info(this.getClass().getName() + ".getFoodList Start");

        // 조회 결과를 전달하기 위한 객체 생성하기
        List<FoodDTO> fList = new LinkedList<>();

        MongoCollection<Document> col = mongodb.getCollection(colNm);

        // 조회 결과 중 출력할 컬럼들(SQL의 SELECT절과 FROM절 가운데 컬럼들과 유사함)
        Document projection = new Document();
        projection.append("food_name", "$food_name");
        projection.append("food_calories", "$food_calories");
        projection.append("food_carbohydrate", "$food_carbohydrate");
        projection.append("food_protein", "$food_protein");
        projection.append("food_fat", "$food_fat");
        projection.append("food_sugar", "food_sugar");
        projection.append("food_natrium", "food_natrium");
        projection.append("food_weight", "food_weight");

        // MongoDB는 무조건 ObjectId가 자동생성되며, ObjectID는 사용하지 않을때, 조회할 필요가 없음
        // ObjectId를 가지고 오지 않을 때 사용함
        projection.append("_id", 0);

        // MongoDB의 find 명령어를 통해 조회할 경우 사용함
        // 조회하는 데이터의 양이 적은 경우, find를 사용하고, 데이터양이 많은 경우 무조건 Aggregate 사용한다.
        FindIterable<Document> rs = col.find(new Document()).projection(projection);

        for (Document doc : rs) {
            if (doc == null) {
                doc = new Document();

            }

            // 조회 잘되나 출력해 봄
            String food_name = CmmUtil.nvl(doc.getString("food_name"));
            String food_calories = CmmUtil.nvl(doc.getString("food_calories"));
            String food_carbohydrate = CmmUtil.nvl(doc.getString("food_carbohydrate"));
            String food_protein = CmmUtil.nvl(doc.getString("food_protein"));
            String food_fat = CmmUtil.nvl(doc.getString("food_fat"));
            String food_sugar = CmmUtil.nvl(doc.getString("food_sugar"));
            String food_natrium = CmmUtil.nvl(doc.getString("food_natrium"));
            String food_weight = CmmUtil.nvl(doc.getString("food_weight"));


            log.info("food_name : " + food_name);
            log.info("food_calories : " + food_calories);
            log.info("food_carbohydrate : " + food_carbohydrate);
            log.info("food_protein : " + food_protein);
            log.info("food_fat : " + food_fat);
            log.info("food_sugar : " + food_sugar);
            log.info("food_natrium : " + food_natrium);
            log.info("food_weight : " + food_weight);

            FoodDTO fDTO = new FoodDTO();

            fDTO.setFood_name(food_name);
            fDTO.setFood_calories(food_calories);
            fDTO.setFood_carbohydrate(food_carbohydrate);
            fDTO.setFood_protein(food_protein);
            fDTO.setFood_fat(food_fat);
            fDTO.setFood_sugar(food_sugar);
            fDTO.setFood_natrium(food_natrium);
            fDTO.setFood_weight(food_weight);


            // 레코드 결과를 List에 저장하기
            fList.add(fDTO);


        }
        log.info(this.getClass().getName() + ".getSongList End!");

        return fList;

    }

    @Override
    public void insertFoodInfo(FoodDTO foDTO) throws Exception {

    }

    @Override
    public void updateFoodInfo(FoodDTO foDTO) throws Exception {

    }

    @Override
    public void deleteFoodInfo(FoodDTO foDTO) throws Exception {

    }


}
