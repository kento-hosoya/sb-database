package com.example.demo.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

//@Mapper 以下はデータベースにアクセスするものとフレームワークに認識させるアノテーション
@Mapper
//インターフェース・・・クラスに似たもので基本的に処理内容をもたないメソッドだけを記述
public interface FoodDao {

	// foodテーブルから、カテゴリ名(category_name) を条件に、該当する全ての食品名(food_name) を取得する
	//ほかにも@Insert @Update等がある
	@Select("""
			SELECT
			  food_name
			FROM
			  food
			WHERE
			  category_name = #{searchWord};
			""")
	public ArrayList<String> selectFoodName(String searchWord);

}
