package logbook.internal;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import logbook.dto.ShipInfoDto;
import logbook.dto.ShipParameters;

import org.apache.commons.lang3.StringUtils;

/**
 * 艦娘
 *
 */
public class Ship {

    /**
     * 艦娘プリセット値
     */
    private static final Map<String, ShipInfoDto> SHIP = new ConcurrentHashMap<String, ShipInfoDto>() {
        {
            this.put("1", new ShipInfoDto("睦月", "駆逐艦", "むつき", 20, 15, 15));
            this.put("2", new ShipInfoDto("如月", "駆逐艦", "きさらぎ", 20, 15, 15));
            this.put("3", ShipInfoDto.EMPTY);
            this.put("4", ShipInfoDto.EMPTY);
            this.put("5", ShipInfoDto.EMPTY);
            this.put("6", new ShipInfoDto("長月", "駆逐艦", "ながつき", 20, 15, 15));
            this.put("7", new ShipInfoDto("三日月", "駆逐艦", "みかづき", 20, 15, 15));
            this.put("8", ShipInfoDto.EMPTY);
            this.put("9", new ShipInfoDto("吹雪", "駆逐艦", "ふぶき", 20, 20, 15));
            this.put("10", new ShipInfoDto("白雪", "駆逐艦", "しらゆき", 20, 20, 15));
            this.put("11", new ShipInfoDto("深雪", "駆逐艦", "みゆき", 20, 20, 15));
            this.put("12", new ShipInfoDto("磯波", "駆逐艦", "いそなみ", 20, 20, 15));
            this.put("13", new ShipInfoDto("綾波", "駆逐艦", "あやなみ", 20, 20, 15));
            this.put("14", new ShipInfoDto("敷波", "駆逐艦", "しきなみ", 20, 20, 15));
            this.put("15", new ShipInfoDto("曙", "駆逐艦", "あけぼの", 20, 20, 15));
            this.put("16", new ShipInfoDto("潮", "駆逐艦", "うしお", 20, 20, 15));
            this.put("17", new ShipInfoDto("陽炎", "駆逐艦", "かげろう", 20, 20, 15));
            this.put("18", new ShipInfoDto("不知火", "駆逐艦", "しらぬい", 20, 20, 15));
            this.put("19", new ShipInfoDto("黒潮", "駆逐艦", "くろしお", 20, 20, 15));
            this.put("20", new ShipInfoDto("雪風", "駆逐艦", "ゆきかぜ", 20, 20, 15));
            this.put("21", new ShipInfoDto("長良", "軽巡洋艦", "ながら", 20, 25, 25));
            this.put("22", new ShipInfoDto("五十鈴", "軽巡洋艦", "いすず", 12, 25, 25));
            this.put("23", new ShipInfoDto("由良", "軽巡洋艦", "ゆら", 20, 25, 25));
            this.put("24", new ShipInfoDto("大井", "軽巡洋艦", "おおい", 10, 25, 25));
            this.put("25", new ShipInfoDto("北上", "軽巡洋艦", "きたかみ", 10, 25, 25));
            this.put("26", new ShipInfoDto("扶桑", "戦艦", "ふそう", 20, 120, 85));
            this.put("27", new ShipInfoDto("山城", "戦艦", "やましろ", 20, 120, 85));
            this.put("28", new ShipInfoDto("皐月", "駆逐艦", "さつき", 20, 15, 15));
            this.put("29", new ShipInfoDto("文月", "駆逐艦", "ふみづき", 20, 15, 15));
            this.put("30", new ShipInfoDto("菊月", "駆逐艦", "きくづき", 20, 15, 15));
            this.put("31", new ShipInfoDto("望月", "駆逐艦", "もちづき", 20, 15, 15));
            this.put("32", new ShipInfoDto("初雪", "駆逐艦", "はつゆき", 20, 20, 15));
            this.put("33", new ShipInfoDto("叢雲", "駆逐艦", "むらくも", 20, 20, 15));
            this.put("34", new ShipInfoDto("暁", "駆逐艦", "あかつき", 20, 20, 15));
            this.put("35", new ShipInfoDto("響", "駆逐艦", "ひびき", 20, 20, 15));
            this.put("36", new ShipInfoDto("雷", "駆逐艦", "いかづち", 20, 20, 15));
            this.put("37", new ShipInfoDto("電", "駆逐艦", "いなづま", 20, 20, 15));
            this.put("38", new ShipInfoDto("初春", "駆逐艦", "はつはる", 20, 20, 15));
            this.put("39", new ShipInfoDto("子日", "駆逐艦", "ねのひ", 20, 20, 15));
            this.put("40", new ShipInfoDto("若葉", "駆逐艦", "わかば", 20, 20, 15));
            this.put("41", new ShipInfoDto("初霜", "駆逐艦", "はつしも", 20, 20, 15));
            this.put("42", new ShipInfoDto("白露", "駆逐艦", "しらつゆ", 20, 20, 15));
            this.put("43", new ShipInfoDto("時雨", "駆逐艦", "しぐれ", 20, 20, 15));
            this.put("44", new ShipInfoDto("村雨", "駆逐艦", "むらさめ", 20, 20, 15));
            this.put("45", new ShipInfoDto("夕立", "駆逐艦", "ゆうだち", 20, 20, 15));
            this.put("46", new ShipInfoDto("五月雨", "駆逐艦", "さみだれ", 20, 20, 15));
            this.put("47", new ShipInfoDto("涼風", "駆逐艦", "すずかぜ", 20, 20, 15));
            this.put("48", new ShipInfoDto("霰", "駆逐艦", "あられ", 20, 20, 15));
            this.put("49", new ShipInfoDto("霞", "駆逐艦", "かすみ", 20, 20, 15));
            this.put("50", new ShipInfoDto("島風", "駆逐艦", "しまかぜ", 20, 25, 20));
            this.put("51", new ShipInfoDto("天龍", "軽巡洋艦", "てんりゅう", 20, 20, 25));
            this.put("52", new ShipInfoDto("龍田", "軽巡洋艦", "たつた", 20, 20, 25));
            this.put("53", new ShipInfoDto("名取", "軽巡洋艦", "なとり", 20, 25, 25));
            this.put("54", new ShipInfoDto("川内", "軽巡洋艦", "せんだい", 20, 25, 25));
            this.put("55", new ShipInfoDto("神通", "軽巡洋艦", "じんつう", 20, 25, 25));
            this.put("56", new ShipInfoDto("那珂", "軽巡洋艦", "なか", 20, 25, 25));
            this.put("57", new ShipInfoDto("大井改", "重雷装巡洋艦", "おおい", 50, 50, 25));
            this.put("58", new ShipInfoDto("北上改", "重雷装巡洋艦", "きたかみ", 50, 50, 25));
            this.put("59", new ShipInfoDto("古鷹", "重巡洋艦", "ふるたか", 25, 50, 35));
            this.put("60", new ShipInfoDto("加古", "重巡洋艦", "かこ", 25, 50, 35));
            this.put("61", new ShipInfoDto("青葉", "重巡洋艦", "あおば", 25, 50, 35));
            this.put("62", new ShipInfoDto("妙高", "重巡洋艦", "みょうこう", 25, 65, 40));
            this.put("63", new ShipInfoDto("那智", "重巡洋艦", "なち", 25, 65, 40));
            this.put("64", new ShipInfoDto("足柄", "重巡洋艦", "あしがら", 25, 65, 40));
            this.put("65", new ShipInfoDto("羽黒", "重巡洋艦", "はぐろ", 25, 65, 40));
            this.put("66", new ShipInfoDto("高雄", "重巡洋艦", "たかお", 25, 65, 40));
            this.put("67", new ShipInfoDto("愛宕", "重巡洋艦", "あたご", 25, 65, 40));
            this.put("68", new ShipInfoDto("摩耶", "重巡洋艦", "まや", 18, 65, 40));
            this.put("69", new ShipInfoDto("鳥海", "重巡洋艦", "ちょうかい", 25, 65, 40));
            this.put("70", new ShipInfoDto("最上", "重巡洋艦", "もがみ", 10, 65, 40));
            this.put("71", new ShipInfoDto("利根", "重巡洋艦", "とね", 25, 60, 45));
            this.put("72", new ShipInfoDto("筑摩", "重巡洋艦", "ちくま", 25, 60, 45));
            this.put("73", new ShipInfoDto("最上改", "航空巡洋艦", "もがみ", 0, 55, 50));
            this.put("74", new ShipInfoDto("祥鳳", "軽空母", "しょうほう", 25, 35, 35));
            this.put("75", new ShipInfoDto("飛鷹", "軽空母", "ひよう", 25, 40, 40));
            this.put("76", new ShipInfoDto("龍驤", "軽空母", "りゅうじょう", 25, 35, 35));
            this.put("77", new ShipInfoDto("伊勢", "戦艦", "いせ", 10, 120, 85));
            this.put("78", new ShipInfoDto("金剛", "戦艦", "こんごう", 25, 110, 80));
            this.put("79", new ShipInfoDto("榛名", "戦艦", "はるな", 25, 110, 80));
            this.put("80", new ShipInfoDto("長門", "戦艦", "ながと", 30, 130, 100));
            this.put("81", new ShipInfoDto("陸奥", "戦艦", "むつ", 30, 130, 100));
            this.put("82", new ShipInfoDto("伊勢改", "航空戦艦", "いせ", 0, 105, 95));
            this.put("83", new ShipInfoDto("赤城", "正規空母", "あかぎ", 30, 55, 60));
            this.put("84", new ShipInfoDto("加賀", "正規空母", "かが", 30, 55, 60));
            this.put("85", new ShipInfoDto("霧島", "戦艦", "きりしま", 25, 110, 80));
            this.put("86", new ShipInfoDto("比叡", "戦艦", "ひえい", 25, 110, 80));
            this.put("87", new ShipInfoDto("日向", "戦艦", "ひゅうが", 10, 120, 85));
            this.put("88", new ShipInfoDto("日向改", "航空戦艦", "ひゅうが", 0, 105, 95));
            this.put("89", new ShipInfoDto("鳳翔", "軽空母", "ほうしょう", 25, 25, 25));
            this.put("90", new ShipInfoDto("蒼龍", "正規空母", "そうりゅう", 30, 50, 50));
            this.put("91", new ShipInfoDto("飛龍", "正規空母", "ひりゅう", 30, 50, 50));
            this.put("92", new ShipInfoDto("隼鷹", "軽空母", "じゅんよう", 25, 40, 40));
            this.put("93", new ShipInfoDto("朧", "駆逐艦", "おぼろ", 20, 20, 15));
            this.put("94", new ShipInfoDto("漣", "駆逐艦", "さざなみ", 20, 20, 15));
            this.put("95", new ShipInfoDto("朝潮", "駆逐艦", "あさしお", 20, 20, 15));
            this.put("96", new ShipInfoDto("大潮", "駆逐艦", "おおしお", 20, 20, 15));
            this.put("97", new ShipInfoDto("満潮", "駆逐艦", "みちしお", 20, 20, 15));
            this.put("98", new ShipInfoDto("荒潮", "駆逐艦", "あらしお", 20, 20, 15));
            this.put("99", new ShipInfoDto("球磨", "軽巡洋艦", "くま", 20, 25, 25));
            this.put("100", new ShipInfoDto("多摩", "軽巡洋艦", "たま", 20, 25, 25));
            this.put("101", new ShipInfoDto("木曾", "軽巡洋艦", "きそ", 20, 25, 25));
            this.put("102", new ShipInfoDto("千歳", "水上機母艦", "ちとせ", 10, 35, 35));
            this.put("103", new ShipInfoDto("千代田", "水上機母艦", "ちよだ", 10, 35, 35));
            this.put("104", new ShipInfoDto("千歳改", "水上機母艦", "ちとせ", 12, 40, 35));
            this.put("105", new ShipInfoDto("千代田改", "水上機母艦", "ちよだ", 12, 40, 35));
            this.put("106", new ShipInfoDto("千歳甲", "水上機母艦", "ちとせ", 15, 45, 35));
            this.put("107", new ShipInfoDto("千代田甲", "水上機母艦", "ちよだ", 15, 45, 35));
            this.put("108", new ShipInfoDto("千歳航", "軽空母", "ちとせ", 35, 40, 40));
            this.put("109", new ShipInfoDto("千代田航", "軽空母", "ちよだ", 35, 40, 40));
            this.put("110", new ShipInfoDto("翔鶴", "正規空母", "しょうかく", 30, 55, 55));
            this.put("111", new ShipInfoDto("瑞鶴", "正規空母", "ずいかく", 25, 55, 55));
            this.put("112", new ShipInfoDto("瑞鶴改", "正規空母", "ずいかく", 0, 70, 65));
            this.put("113", new ShipInfoDto("鬼怒", "軽巡洋艦", "きぬ", 17, 25, 25));
            this.put("114", new ShipInfoDto("阿武隈", "軽巡洋艦", "あぶくま", 17, 25, 25));
            this.put("115", new ShipInfoDto("夕張", "軽巡洋艦", "ゆうばり", 25, 30, 20));
            this.put("116", new ShipInfoDto("瑞鳳", "軽空母", "ずいほう", 25, 35, 35));
            this.put("117", new ShipInfoDto("瑞鳳改", "軽空母", "ずいほう", 0, 40, 40));
            this.put("118", new ShipInfoDto("大井改二", "重雷装巡洋艦", "おおい", 0, 75, 25));
            this.put("119", new ShipInfoDto("北上改二", "重雷装巡洋艦", "きたかみ", 0, 75, 25));
            this.put("120", new ShipInfoDto("三隈", "重巡洋艦", "みくま", 30, 65, 40));
            this.put("121", new ShipInfoDto("三隈改", "航空巡洋艦", "みくま", 0, 55, 50));
            this.put("122", new ShipInfoDto("舞風", "駆逐艦", "まいかぜ", 20, 20, 15));
            this.put("123", new ShipInfoDto("衣笠", "重巡洋艦", "きぬがさ", 25, 50, 35));
            this.put("124", new ShipInfoDto("鈴谷", "重巡洋艦", "すずや", 35, 65, 40));
            this.put("125", new ShipInfoDto("熊野", "重巡洋艦", "くまの", 35, 65, 40));
            this.put("126", new ShipInfoDto("伊168", "潜水艦", "い168", 50, 20, 10));
            this.put("127", new ShipInfoDto("伊58", "潜水艦", "い58", 50, 20, 10));
            this.put("128", new ShipInfoDto("伊8", "潜水艦", "い8", 50, 20, 10));
            this.put("129", new ShipInfoDto("鈴谷改", "航空巡洋艦", "すずや", 0, 55, 50));
            this.put("130", new ShipInfoDto("熊野改", "航空巡洋艦", "くまの", 0, 55, 50));
            this.put("131", new ShipInfoDto("大和", "戦艦", "やまと", 60, 300, 250));
            this.put("132", new ShipInfoDto("秋雲", "駆逐艦", "あきぐも", 30, 20, 15));
            this.put("133", new ShipInfoDto("夕雲", "駆逐艦", "ゆうぐも", 30, 20, 15));
            this.put("134", new ShipInfoDto("巻雲", "駆逐艦", "まきぐも", 30, 20, 15));
            this.put("135", new ShipInfoDto("長波", "駆逐艦", "ながなみ", 30, 20, 15));
            this.put("136", new ShipInfoDto("大和改", "戦艦", "やまと", 0, 325, 250));
            this.put("137", new ShipInfoDto("阿賀野", "軽巡洋艦", "あがの", 35, 35, 30));
            this.put("138", new ShipInfoDto("能代", "軽巡洋艦", "のしろ", 35, 35, 30));
            this.put("139", new ShipInfoDto("矢矧", "軽巡洋艦", "やはぎ", 35, 35, 30));
            this.put("140", new ShipInfoDto("酒匂", "軽巡洋艦", "さかわ", 35, 35, 30));
            this.put("141", new ShipInfoDto("五十鈴改二", "軽巡洋艦", "いすず", 0, 30, 25));
            this.put("142", new ShipInfoDto("衣笠改二", "重巡洋艦", "きぬがさ", 0, 65, 35));
            this.put("143", new ShipInfoDto("武蔵", "戦艦", "むさし", 40, 300, 250));
            this.put("144", new ShipInfoDto("夕立改二", "駆逐艦", "ゆうだち", 0, 20, 15));
            this.put("145", new ShipInfoDto("時雨改二", "駆逐艦", "しぐれ", 0, 20, 15));
            this.put("146", new ShipInfoDto("木曾改二", "重雷装巡洋艦", "きそ", 0, 50, 25));
            this.put("147", new ShipInfoDto("Верный", "駆逐艦", "ひびき", 0, 25, 15));
            this.put("148", new ShipInfoDto("武蔵改", "戦艦", "むさし", 0, 325, 250));
            this.put("149", new ShipInfoDto("金剛改二", "戦艦", "こんごう", 0, 125, 100));
            this.put("150", new ShipInfoDto("比叡改二", "戦艦", "ひえい", 0, 125, 100));
            this.put("151", new ShipInfoDto("榛名改二", "戦艦", "はるな", 0, 125, 100));
            this.put("152", new ShipInfoDto("霧島改二", "戦艦", "きりしま", 0, 125, 100));
            this.put("153", new ShipInfoDto("大鳳", "装甲空母", "たいほう", 40, 65, 70));
            this.put("154", new ShipInfoDto("香取", "練習巡洋艦", "かとり", 35, 15, 30));
            this.put("155", new ShipInfoDto("伊401", "潜水空母", "い401", 35, 15, 20));
            this.put("156", new ShipInfoDto("大鳳改", "装甲空母", "たいほう", 0, 75, 90));
            this.put("157", new ShipInfoDto("龍驤改二", "軽空母", "りゅうじょう", 0, 45, 40));
            this.put("158", new ShipInfoDto("川内改二", "軽巡洋艦", "せんだい", 0, 35, 25));
            this.put("159", new ShipInfoDto("神通改二", "軽巡洋艦", "じんつう", 0, 35, 25));
            this.put("160", new ShipInfoDto("那珂改二", "軽巡洋艦", "なか", 0, 35, 25));
            this.put("161", new ShipInfoDto("あきつ丸", "揚陸艦", "あきつまる", 25, 10, 40));
            this.put("162", ShipInfoDto.EMPTY);
            this.put("163", new ShipInfoDto("まるゆ", "潜水艦", "まるゆ", 20, 5, 10));
            this.put("164", new ShipInfoDto("弥生", "駆逐艦", "やよい", 20, 15, 15));
            this.put("165", new ShipInfoDto("卯月", "駆逐艦", "うづき", 25, 15, 15));
            this.put("166", new ShipInfoDto("あきつ丸改", "揚陸艦", "あきつまる", 0, 25, 45));
            this.put("167", new ShipInfoDto("磯風", "駆逐艦", "いそかぜ", 45, 20, 15));
            this.put("168", new ShipInfoDto("浦風", "駆逐艦", "うらかぜ", 35, 20, 15));
            this.put("169", new ShipInfoDto("谷風", "駆逐艦", "たにかぜ", 30, 20, 15));
            this.put("170", new ShipInfoDto("浜風", "駆逐艦", "はまかぜ", 30, 20, 15));
            this.put("171", new ShipInfoDto("Bismarck", "戦艦", "ビスマルク", 30, 110, 90));
            this.put("172", new ShipInfoDto("Bismarck改", "戦艦", "ビスマルク", 50, 115, 95));
            this.put("173", new ShipInfoDto("Bismarckzwei", "戦艦", "ビスマルク", 75, 135, 105));
            this.put("174", new ShipInfoDto("Z1", "駆逐艦", "レーベレヒト・マース", 30, 20, 20));
            this.put("175", new ShipInfoDto("Z3", "駆逐艦", "マックス・シュルツ", 30, 20, 20));
            this.put("176", new ShipInfoDto("PrinzEugen", "重巡洋艦", "プリンツ・オイゲン", 45, 70, 50));
            this.put("177", new ShipInfoDto("PrinzEugen改", "重巡洋艦", "プリンツ・オイゲン", 0, 75, 55));
            this.put("178", new ShipInfoDto("Bismarckdrei", "戦艦", "ビスマルク", 0, 155, 110));
            this.put("179", new ShipInfoDto("Z1zwei", "駆逐艦", "レーベレヒト・マース", 0, 25, 20));
            this.put("180", new ShipInfoDto("Z3zwei", "駆逐艦", "マックス・シュルツ", 0, 25, 20));
            this.put("181", new ShipInfoDto("天津風", "駆逐艦", "あまつかぜ", 20, 20, 20));
            this.put("182", new ShipInfoDto("明石", "工作艦", "あかし", 35, 10, 50));
            this.put("183", new ShipInfoDto("大淀", "軽巡洋艦", "おおよど", 35, 30, 35));
            this.put("184", new ShipInfoDto("大鯨", "潜水母艦", "たいげい・りゅうほう", 25, 10, 35));
            this.put("185", new ShipInfoDto("龍鳳", "軽空母", "たいげい・りゅうほう", 50, 35, 35));
            this.put("186", new ShipInfoDto("時津風", "駆逐艦", "ときつかぜ", 30, 20, 15));
            this.put("187", new ShipInfoDto("明石改", "工作艦", "あかし", 0, 15, 55));
            this.put("188", new ShipInfoDto("利根改二", "航空巡洋艦", "とね", 0, 65, 50));
            this.put("189", new ShipInfoDto("筑摩改二", "航空巡洋艦", "ちくま", 0, 65, 50));
            this.put("190", new ShipInfoDto("初風", "駆逐艦", "はつかぜ", 20, 20, 15));
            this.put("191", new ShipInfoDto("伊19", "潜水艦", "い19", 50, 20, 10));
            this.put("192", new ShipInfoDto("那智改二", "重巡洋艦", "なち", 0, 75, 45));
            this.put("193", new ShipInfoDto("足柄改二", "重巡洋艦", "あしがら", 0, 75, 45));
            this.put("194", new ShipInfoDto("羽黒改二", "重巡洋艦", "はぐろ", 0, 75, 45));
            this.put("195", new ShipInfoDto("綾波改二", "駆逐艦", "あやなみ", 0, 20, 15));
            this.put("196", new ShipInfoDto("飛龍改二", "正規空母", "ひりゅう", 0, 75, 70));
            this.put("197", new ShipInfoDto("蒼龍改二", "正規空母", "そうりゅう", 0, 75, 70));
            this.put("198", ShipInfoDto.EMPTY);
            this.put("199", ShipInfoDto.EMPTY);
            this.put("200", ShipInfoDto.EMPTY);
            this.put("201", new ShipInfoDto("吹雪改", "駆逐艦", "ふぶき", 70, 20, 15));
            this.put("202", new ShipInfoDto("白雪改", "駆逐艦", "しらゆき", 0, 20, 15));
            this.put("203", new ShipInfoDto("初雪改", "駆逐艦", "はつゆき", 0, 20, 15));
            this.put("204", new ShipInfoDto("深雪改", "駆逐艦", "みゆき", 0, 20, 15));
            this.put("205", new ShipInfoDto("叢雲改", "駆逐艦", "むらくも", 0, 20, 15));
            this.put("206", new ShipInfoDto("磯波改", "駆逐艦", "いそなみ", 0, 20, 15));
            this.put("207", new ShipInfoDto("綾波改", "駆逐艦", "あやなみ", 70, 20, 15));
            this.put("208", new ShipInfoDto("敷波改", "駆逐艦", "しきなみ", 0, 20, 15));
            this.put("209", new ShipInfoDto("金剛改", "戦艦", "こんごう", 75, 120, 90));
            this.put("210", new ShipInfoDto("比叡改", "戦艦", "ひえい", 75, 120, 90));
            this.put("211", new ShipInfoDto("榛名改", "戦艦", "はるな", 80, 120, 90));
            this.put("212", new ShipInfoDto("霧島改", "戦艦", "きりしま", 75, 120, 90));
            this.put("213", new ShipInfoDto("天龍改", "軽巡洋艦", "てんりゅう", 0, 25, 25));
            this.put("214", new ShipInfoDto("龍田改", "軽巡洋艦", "たつた", 0, 25, 25));
            this.put("215", new ShipInfoDto("球磨改", "軽巡洋艦", "くま", 0, 30, 25));
            this.put("216", new ShipInfoDto("多摩改", "軽巡洋艦", "たま", 0, 30, 25));
            this.put("217", new ShipInfoDto("木曾改", "軽巡洋艦", "きそ", 65, 30, 25));
            this.put("218", new ShipInfoDto("長良改", "軽巡洋艦", "ながら", 0, 30, 25));
            this.put("219", new ShipInfoDto("五十鈴改", "軽巡洋艦", "いすず", 50, 30, 25));
            this.put("220", new ShipInfoDto("由良改", "軽巡洋艦", "ゆら", 0, 30, 25));
            this.put("221", new ShipInfoDto("名取改", "軽巡洋艦", "なとり", 0, 30, 25));
            this.put("222", new ShipInfoDto("川内改", "軽巡洋艦", "せんだい", 60, 30, 25));
            this.put("223", new ShipInfoDto("神通改", "軽巡洋艦", "じんつう", 60, 30, 25));
            this.put("224", new ShipInfoDto("那珂改", "軽巡洋艦", "なか", 48, 30, 25));
            this.put("225", new ShipInfoDto("陽炎改", "駆逐艦", "かげろう", 0, 20, 15));
            this.put("226", new ShipInfoDto("不知火改", "駆逐艦", "しらぬい", 0, 20, 15));
            this.put("227", new ShipInfoDto("黒潮改", "駆逐艦", "くろしお", 0, 20, 15));
            this.put("228", new ShipInfoDto("雪風改", "駆逐艦", "ゆきかぜ", 0, 20, 15));
            this.put("229", new ShipInfoDto("島風改", "駆逐艦", "しまかぜ", 0, 25, 20));
            this.put("230", new ShipInfoDto("朧改", "駆逐艦", "おぼろ", 0, 20, 15));
            this.put("231", new ShipInfoDto("曙改", "駆逐艦", "あけぼの", 0, 20, 15));
            this.put("232", new ShipInfoDto("漣改", "駆逐艦", "さざなみ", 0, 20, 15));
            this.put("233", new ShipInfoDto("潮改", "駆逐艦", "うしお", 60, 20, 15));
            this.put("234", new ShipInfoDto("暁改", "駆逐艦", "あかつき", 0, 20, 15));
            this.put("235", new ShipInfoDto("響改", "駆逐艦", "ひびき", 70, 20, 15));
            this.put("236", new ShipInfoDto("雷改", "駆逐艦", "いかづち", 0, 20, 15));
            this.put("237", new ShipInfoDto("電改", "駆逐艦", "いなづま", 0, 20, 15));
            this.put("238", new ShipInfoDto("初春改", "駆逐艦", "はつはる", 65, 20, 15));
            this.put("239", new ShipInfoDto("子日改", "駆逐艦", "ねのひ", 0, 20, 15));
            this.put("240", new ShipInfoDto("若葉改", "駆逐艦", "わかば", 0, 20, 15));
            this.put("241", new ShipInfoDto("初霜改", "駆逐艦", "はつしも", 70, 20, 15));
            this.put("242", new ShipInfoDto("白露改", "駆逐艦", "しらつゆ", 0, 20, 15));
            this.put("243", new ShipInfoDto("時雨改", "駆逐艦", "しぐれ", 60, 20, 15));
            this.put("244", new ShipInfoDto("村雨改", "駆逐艦", "むらさめ", 0, 20, 15));
            this.put("245", new ShipInfoDto("夕立改", "駆逐艦", "ゆうだち", 55, 20, 15));
            this.put("246", new ShipInfoDto("五月雨改", "駆逐艦", "さみだれ", 0, 20, 15));
            this.put("247", new ShipInfoDto("涼風改", "駆逐艦", "すずかぜ", 0, 20, 15));
            this.put("248", new ShipInfoDto("朝潮改", "駆逐艦", "あさしお", 0, 20, 15));
            this.put("249", new ShipInfoDto("大潮改", "駆逐艦", "おおしお", 0, 20, 15));
            this.put("250", new ShipInfoDto("満潮改", "駆逐艦", "みちしお", 0, 20, 15));
            this.put("251", new ShipInfoDto("荒潮改", "駆逐艦", "あらしお", 0, 20, 15));
            this.put("252", new ShipInfoDto("霰改", "駆逐艦", "あられ", 0, 20, 15));
            this.put("253", new ShipInfoDto("霞改", "駆逐艦", "かすみ", 0, 20, 15));
            this.put("254", new ShipInfoDto("睦月改", "駆逐艦", "むつき", 0, 15, 15));
            this.put("255", new ShipInfoDto("如月改", "駆逐艦", "きさらぎ", 0, 15, 15));
            this.put("256", new ShipInfoDto("皐月改", "駆逐艦", "さつき", 0, 15, 15));
            this.put("257", new ShipInfoDto("文月改", "駆逐艦", "ふみづき", 0, 15, 15));
            this.put("258", new ShipInfoDto("長月改", "駆逐艦", "ながつき", 0, 15, 15));
            this.put("259", new ShipInfoDto("菊月改", "駆逐艦", "きくづき", 0, 15, 15));
            this.put("260", new ShipInfoDto("三日月改", "駆逐艦", "みかづき", 0, 15, 15));
            this.put("261", new ShipInfoDto("望月改", "駆逐艦", "もちづき", 0, 15, 15));
            this.put("262", new ShipInfoDto("古鷹改", "重巡洋艦", "ふるたか", 65, 55, 35));
            this.put("263", new ShipInfoDto("加古改", "重巡洋艦", "かこ", 0, 55, 35));
            this.put("264", new ShipInfoDto("青葉改", "重巡洋艦", "あおば", 0, 55, 35));
            this.put("265", new ShipInfoDto("妙高改", "重巡洋艦", "みょうこう", 70, 70, 40));
            this.put("266", new ShipInfoDto("那智改", "重巡洋艦", "なち", 65, 70, 40));
            this.put("267", new ShipInfoDto("足柄改", "重巡洋艦", "あしがら", 65, 70, 40));
            this.put("268", new ShipInfoDto("羽黒改", "重巡洋艦", "はぐろ", 65, 70, 40));
            this.put("269", new ShipInfoDto("高雄改", "重巡洋艦", "たかお", 0, 70, 40));
            this.put("270", new ShipInfoDto("愛宕改", "重巡洋艦", "あたご", 0, 70, 40));
            this.put("271", new ShipInfoDto("摩耶改", "重巡洋艦", "まや", 0, 70, 40));
            this.put("272", new ShipInfoDto("鳥海改", "重巡洋艦", "ちょうかい", 0, 70, 40));
            this.put("273", new ShipInfoDto("利根改", "重巡洋艦", "とね", 70, 65, 45));
            this.put("274", new ShipInfoDto("筑摩改", "重巡洋艦", "ちくま", 70, 65, 45));
            this.put("275", new ShipInfoDto("長門改", "戦艦", "ながと", 0, 160, 100));
            this.put("276", new ShipInfoDto("陸奥改", "戦艦", "むつ", 0, 160, 100));
            this.put("277", new ShipInfoDto("赤城改", "正規空母", "あかぎ", 0, 75, 75));
            this.put("278", new ShipInfoDto("加賀改", "正規空母", "かが", 0, 80, 80));
            this.put("279", new ShipInfoDto("蒼龍改", "正規空母", "そうりゅう", 78, 65, 65));
            this.put("280", new ShipInfoDto("飛龍改", "正規空母", "ひりゅう", 77, 65, 65));
            this.put("281", new ShipInfoDto("龍驤改", "軽空母", "りゅうじょう", 75, 40, 40));
            this.put("282", new ShipInfoDto("祥鳳改", "軽空母", "しょうほう", 0, 40, 40));
            this.put("283", new ShipInfoDto("飛鷹改", "軽空母", "ひよう", 0, 45, 45));
            this.put("284", new ShipInfoDto("隼鷹改", "軽空母", "じゅんよう", 80, 45, 45));
            this.put("285", new ShipInfoDto("鳳翔改", "軽空母", "ほうしょう", 0, 30, 30));
            this.put("286", new ShipInfoDto("扶桑改", "航空戦艦", "ふそう", 80, 105, 95));
            this.put("287", new ShipInfoDto("山城改", "航空戦艦", "やましろ", 80, 105, 95));
            this.put("288", new ShipInfoDto("翔鶴改", "正規空母", "しょうかく", 0, 70, 65));
            this.put("289", new ShipInfoDto("鬼怒改", "軽巡洋艦", "きぬ", 0, 35, 25));
            this.put("290", new ShipInfoDto("阿武隈改", "軽巡洋艦", "あぶくま", 0, 35, 25));
            this.put("291", new ShipInfoDto("千歳航改", "軽空母", "ちとせ", 50, 40, 45));
            this.put("292", new ShipInfoDto("千代田航改", "軽空母", "ちよだ", 50, 40, 45));
            this.put("293", new ShipInfoDto("夕張改", "軽巡洋艦", "ゆうばり", 0, 40, 25));
            this.put("294", new ShipInfoDto("舞風改", "駆逐艦", "まいかぜ", 0, 20, 15));
            this.put("295", new ShipInfoDto("衣笠改", "重巡洋艦", "きぬがさ", 55, 60, 35));
            this.put("296", new ShipInfoDto("千歳航改二", "軽空母", "ちとせ", 0, 40, 45));
            this.put("297", new ShipInfoDto("千代田航改二", "軽空母", "ちよだ", 0, 40, 45));
            this.put("298", ShipInfoDto.EMPTY);
            this.put("299", ShipInfoDto.EMPTY);
            this.put("300", new ShipInfoDto("初風改", "駆逐艦", "はつかぜ", 0, 20, 15));
            this.put("301", new ShipInfoDto("秋雲改", "駆逐艦", "あきぐも", 0, 20, 15));
            this.put("302", new ShipInfoDto("夕雲改", "駆逐艦", "ゆうぐも", 0, 20, 15));
            this.put("303", new ShipInfoDto("巻雲改", "駆逐艦", "まきぐも", 0, 20, 15));
            this.put("304", new ShipInfoDto("長波改", "駆逐艦", "ながなみ", 0, 20, 15));
            this.put("305", new ShipInfoDto("阿賀野改", "軽巡洋艦", "あがの", 0, 40, 30));
            this.put("306", new ShipInfoDto("能代改", "軽巡洋艦", "のしろ", 0, 40, 30));
            this.put("307", new ShipInfoDto("矢矧改", "軽巡洋艦", "やはぎ", 0, 40, 30));
            this.put("308", new ShipInfoDto("弥生改", "駆逐艦", "やよい", 0, 15, 15));
            this.put("309", new ShipInfoDto("卯月改", "駆逐艦", "うづき", 0, 15, 15));
            this.put("310", new ShipInfoDto("Z1改", "駆逐艦", "レーベレヒト・マース", 70, 25, 20));
            this.put("311", new ShipInfoDto("Z3改", "駆逐艦", "マックス・シュルツ", 70, 25, 20));
            this.put("312", new ShipInfoDto("浜風改", "駆逐艦", "はまかぜ", 0, 20, 15));
            this.put("313", new ShipInfoDto("谷風改", "駆逐艦", "たにかぜ", 0, 20, 15));
            this.put("314", new ShipInfoDto("酒匂改", "軽巡洋艦", "さかわ", 0, 40, 30));
            this.put("315", ShipInfoDto.EMPTY);
            this.put("316", new ShipInfoDto("天津風改", "駆逐艦", "あまつかぜ", 0, 20, 20));
            this.put("317", new ShipInfoDto("浦風改", "駆逐艦", "うらかぜ", 0, 20, 15));
            this.put("318", new ShipInfoDto("龍鳳改", "軽空母", "たいげい・りゅうほう", 0, 40, 35));
            this.put("319", new ShipInfoDto("妙高改二", "重巡洋艦", "みょうこう", 0, 75, 45));
            this.put("320", new ShipInfoDto("磯風改", "駆逐艦", "いそかぜ", 0, 20, 15));
            this.put("321", new ShipInfoDto("大淀改", "軽巡洋艦", "おおよど", 0, 35, 35));
            this.put("322", new ShipInfoDto("時津風改", "駆逐艦", "ときつかぜ", 0, 20, 15));
            this.put("323", new ShipInfoDto("春雨改", "駆逐艦", "はるさめ", 0, 20, 15));
            this.put("324", new ShipInfoDto("早霜改", "駆逐艦", "はやしも", 0, 20, 15));
            this.put("325", new ShipInfoDto("清霜改", "駆逐艦", "きよしも", 0, 20, 15));
            this.put("326", new ShipInfoDto("初春改二", "駆逐艦", "はつはる", 0, 20, 15));
            this.put("327", new ShipInfoDto("朝雲改", "駆逐艦", "あさぐも", 0, 20, 15));
            this.put("328", new ShipInfoDto("山雲改", "駆逐艦", "やまぐも", 0, 20, 15));
            this.put("329", new ShipInfoDto("野分改", "駆逐艦", "のわき", 0, 20, 15));
            this.put("330", new ShipInfoDto("秋月改", "駆逐艦", "あきづき", 0, 25, 20));
            this.put("331", new ShipInfoDto("天城", "正規空母", "あまぎ", 50, 45, 50));
            this.put("332", ShipInfoDto.EMPTY);
            this.put("333", ShipInfoDto.EMPTY);
            this.put("334", new ShipInfoDto("U-511改", "潜水艦", "ゆー511・ろ500", 55, 20, 10));
            this.put("335", ShipInfoDto.EMPTY);
            this.put("336", ShipInfoDto.EMPTY);
            this.put("337", ShipInfoDto.EMPTY);
            this.put("338", ShipInfoDto.EMPTY);
            this.put("339", ShipInfoDto.EMPTY);
            this.put("340", ShipInfoDto.EMPTY);
            this.put("341", ShipInfoDto.EMPTY);
            this.put("342", ShipInfoDto.EMPTY);
            this.put("343", new ShipInfoDto("香取改", "練習巡洋艦", "かとり", 0, 20, 35));
            this.put("344", new ShipInfoDto("朝霜改", "駆逐艦", "あさしも", 0, 20, 15));
            this.put("345", ShipInfoDto.EMPTY);
            this.put("346", ShipInfoDto.EMPTY);
            this.put("347", ShipInfoDto.EMPTY);
            this.put("348", ShipInfoDto.EMPTY);
            this.put("349", ShipInfoDto.EMPTY);
            this.put("350", ShipInfoDto.EMPTY);
            this.put("351", ShipInfoDto.EMPTY);
            this.put("352", ShipInfoDto.EMPTY);
            this.put("353", ShipInfoDto.EMPTY);
            this.put("354", ShipInfoDto.EMPTY);
            this.put("355", ShipInfoDto.EMPTY);
            this.put("356", ShipInfoDto.EMPTY);
            this.put("357", ShipInfoDto.EMPTY);
            this.put("358", ShipInfoDto.EMPTY);
            this.put("359", ShipInfoDto.EMPTY);
            this.put("360", ShipInfoDto.EMPTY);
            this.put("361", ShipInfoDto.EMPTY);
            this.put("362", ShipInfoDto.EMPTY);
            this.put("363", ShipInfoDto.EMPTY);
            this.put("364", ShipInfoDto.EMPTY);
            this.put("365", ShipInfoDto.EMPTY);
            this.put("366", ShipInfoDto.EMPTY);
            this.put("367", ShipInfoDto.EMPTY);
            this.put("368", ShipInfoDto.EMPTY);
            this.put("369", ShipInfoDto.EMPTY);
            this.put("370", ShipInfoDto.EMPTY);
            this.put("371", ShipInfoDto.EMPTY);
            this.put("372", ShipInfoDto.EMPTY);
            this.put("373", ShipInfoDto.EMPTY);
            this.put("374", ShipInfoDto.EMPTY);
            this.put("375", ShipInfoDto.EMPTY);
            this.put("376", ShipInfoDto.EMPTY);
            this.put("377", ShipInfoDto.EMPTY);
            this.put("378", ShipInfoDto.EMPTY);
            this.put("379", ShipInfoDto.EMPTY);
            this.put("380", ShipInfoDto.EMPTY);
            this.put("381", ShipInfoDto.EMPTY);
            this.put("382", ShipInfoDto.EMPTY);
            this.put("383", ShipInfoDto.EMPTY);
            this.put("384", ShipInfoDto.EMPTY);
            this.put("385", ShipInfoDto.EMPTY);
            this.put("386", ShipInfoDto.EMPTY);
            this.put("387", ShipInfoDto.EMPTY);
            this.put("388", ShipInfoDto.EMPTY);
            this.put("389", ShipInfoDto.EMPTY);
            this.put("390", ShipInfoDto.EMPTY);
            this.put("391", ShipInfoDto.EMPTY);
            this.put("392", ShipInfoDto.EMPTY);
            this.put("393", ShipInfoDto.EMPTY);
            this.put("394", ShipInfoDto.EMPTY);
            this.put("395", ShipInfoDto.EMPTY);
            this.put("396", ShipInfoDto.EMPTY);
            this.put("397", ShipInfoDto.EMPTY);
            this.put("398", new ShipInfoDto("伊168改", "潜水艦", "い168", 0, 20, 10));
            this.put("399", new ShipInfoDto("伊58改", "潜水空母", "い58", 0, 25, 10));
            this.put("400", new ShipInfoDto("伊8改", "潜水空母", "い8", 0, 25, 10));
            this.put("401", new ShipInfoDto("伊19改", "潜水空母", "い19", 0, 25, 10));
            this.put("402", new ShipInfoDto("まるゆ改", "潜水艦", "まるゆ", 0, 10, 10));
            this.put("403", new ShipInfoDto("伊401改", "潜水空母", "い401", 0, 30, 25));
            this.put("404", new ShipInfoDto("雲龍", "正規空母", "うんりゅう", 50, 45, 50));
            this.put("405", new ShipInfoDto("春雨", "駆逐艦", "はるさめ", 30, 20, 15));
            this.put("406", new ShipInfoDto("雲龍改", "正規空母", "うんりゅう", 0, 55, 50));
            this.put("407", new ShipInfoDto("潮改二", "駆逐艦", "うしお", 0, 20, 15));
            this.put("408", new ShipInfoDto("隼鷹改二", "軽空母", "じゅんよう", 0, 50, 45));
            this.put("409", new ShipInfoDto("早霜", "駆逐艦", "はやしも", 30, 20, 15));
            this.put("410", new ShipInfoDto("清霜", "駆逐艦", "きよしも", 30, 20, 15));
            this.put("411", new ShipInfoDto("扶桑改二", "航空戦艦", "ふそう", 0, 140, 105));
            this.put("412", new ShipInfoDto("山城改二", "航空戦艦", "やましろ", 0, 140, 105));
            this.put("413", new ShipInfoDto("朝雲", "駆逐艦", "あさぐも", 35, 20, 15));
            this.put("414", new ShipInfoDto("山雲", "駆逐艦", "やまぐも", 35, 20, 15));
            this.put("415", new ShipInfoDto("野分", "駆逐艦", "のわき", 35, 20, 15));
            this.put("416", new ShipInfoDto("古鷹改二", "重巡洋艦", "ふるたか", 0, 65, 35));
            this.put("417", ShipInfoDto.EMPTY);
            this.put("418", ShipInfoDto.EMPTY);
            this.put("419", new ShipInfoDto("初霜改二", "駆逐艦", "はつしも", 0, 20, 15));
            this.put("420", ShipInfoDto.EMPTY);
            this.put("421", new ShipInfoDto("秋月", "駆逐艦", "あきづき", 40, 25, 20));
            this.put("422", ShipInfoDto.EMPTY);
            this.put("423", ShipInfoDto.EMPTY);
            this.put("424", ShipInfoDto.EMPTY);
            this.put("425", new ShipInfoDto("朝霜", "駆逐艦", "あさしも", 45, 20, 15));
            this.put("426", new ShipInfoDto("吹雪改二", "駆逐艦", "ふぶき", 0, 20, 15));
            this.put("427", ShipInfoDto.EMPTY);
            this.put("428", ShipInfoDto.EMPTY);
            this.put("429", new ShipInfoDto("天城改", "正規空母", "あまぎ", 0, 55, 50));
            this.put("430", ShipInfoDto.EMPTY);
            this.put("431", new ShipInfoDto("U-511", "潜水艦", "ゆー511・ろ500", 35, 20, 10));
            this.put("432", ShipInfoDto.EMPTY);
            this.put("433", ShipInfoDto.EMPTY);
            this.put("434", ShipInfoDto.EMPTY);
            this.put("435", ShipInfoDto.EMPTY);
            this.put("436", new ShipInfoDto("呂500", "潜水艦", "ゆー511・ろ500", 0, 20, 10));
            this.put("437", ShipInfoDto.EMPTY);
            this.put("438", ShipInfoDto.EMPTY);
            this.put("439", ShipInfoDto.EMPTY);
            this.put("440", ShipInfoDto.EMPTY);
            this.put("441", ShipInfoDto.EMPTY);
            this.put("442", ShipInfoDto.EMPTY);
            this.put("443", ShipInfoDto.EMPTY);
            this.put("444", ShipInfoDto.EMPTY);
            this.put("445", ShipInfoDto.EMPTY);
            this.put("446", ShipInfoDto.EMPTY);
            this.put("447", ShipInfoDto.EMPTY);
            this.put("448", ShipInfoDto.EMPTY);
            this.put("449", ShipInfoDto.EMPTY);
            this.put("450", ShipInfoDto.EMPTY);
            this.put("451", ShipInfoDto.EMPTY);
            this.put("452", ShipInfoDto.EMPTY);
            this.put("453", ShipInfoDto.EMPTY);
            this.put("454", ShipInfoDto.EMPTY);
            this.put("455", ShipInfoDto.EMPTY);
            this.put("456", ShipInfoDto.EMPTY);
            this.put("457", ShipInfoDto.EMPTY);
            this.put("458", ShipInfoDto.EMPTY);
            this.put("459", ShipInfoDto.EMPTY);
            this.put("460", ShipInfoDto.EMPTY);
            this.put("461", ShipInfoDto.EMPTY);
            this.put("462", ShipInfoDto.EMPTY);
            this.put("463", ShipInfoDto.EMPTY);
            this.put("464", ShipInfoDto.EMPTY);
            this.put("465", ShipInfoDto.EMPTY);
            this.put("466", ShipInfoDto.EMPTY);
            this.put("467", ShipInfoDto.EMPTY);
            this.put("468", ShipInfoDto.EMPTY);
            this.put("469", ShipInfoDto.EMPTY);
            this.put("470", ShipInfoDto.EMPTY);
            this.put("471", ShipInfoDto.EMPTY);
            this.put("472", ShipInfoDto.EMPTY);
            this.put("473", ShipInfoDto.EMPTY);
            this.put("474", ShipInfoDto.EMPTY);
            this.put("475", ShipInfoDto.EMPTY);
            this.put("476", ShipInfoDto.EMPTY);
            this.put("477", ShipInfoDto.EMPTY);
            this.put("478", ShipInfoDto.EMPTY);
            this.put("479", ShipInfoDto.EMPTY);
            this.put("480", ShipInfoDto.EMPTY);
            this.put("481", ShipInfoDto.EMPTY);
            this.put("482", ShipInfoDto.EMPTY);
            this.put("483", ShipInfoDto.EMPTY);
            this.put("484", ShipInfoDto.EMPTY);
            this.put("485", ShipInfoDto.EMPTY);
            this.put("486", ShipInfoDto.EMPTY);
            this.put("487", ShipInfoDto.EMPTY);
            this.put("488", ShipInfoDto.EMPTY);
            this.put("489", ShipInfoDto.EMPTY);
            this.put("490", ShipInfoDto.EMPTY);
            this.put("491", ShipInfoDto.EMPTY);
            this.put("492", ShipInfoDto.EMPTY);
            this.put("493", ShipInfoDto.EMPTY);
            this.put("494", ShipInfoDto.EMPTY);
            this.put("495", ShipInfoDto.EMPTY);
            this.put("496", ShipInfoDto.EMPTY);
            this.put("497", ShipInfoDto.EMPTY);
            this.put("498", ShipInfoDto.EMPTY);
            this.put("499", ShipInfoDto.EMPTY);
            this.put("500", ShipInfoDto.EMPTY);
            this.put("501", new ShipInfoDto("駆逐イ級", "駆逐艦", "", 0, 0, 0));
            this.put("502", new ShipInfoDto("駆逐ロ級", "駆逐艦", "", 0, 0, 0));
            this.put("503", new ShipInfoDto("駆逐ハ級", "駆逐艦", "", 0, 0, 0));
            this.put("504", new ShipInfoDto("駆逐ニ級", "駆逐艦", "", 0, 0, 0));
            this.put("505", new ShipInfoDto("軽巡ホ級", "軽巡洋艦", "", 0, 0, 0));
            this.put("506", new ShipInfoDto("軽巡ヘ級", "軽巡洋艦", "", 0, 0, 0));
            this.put("507", new ShipInfoDto("軽巡ト級", "軽巡洋艦", "", 0, 0, 0));
            this.put("508", new ShipInfoDto("雷巡チ級", "重雷装巡洋艦", "", 0, 0, 0));
            this.put("509", new ShipInfoDto("重巡リ級", "重巡洋艦", "", 0, 0, 0));
            this.put("510", new ShipInfoDto("軽母ヌ級", "軽空母", "", 0, 0, 0));
            this.put("511", new ShipInfoDto("戦艦ル級", "戦艦", "", 0, 0, 0));
            this.put("512", new ShipInfoDto("空母ヲ級", "正規空母", "", 0, 0, 0));
            this.put("513", new ShipInfoDto("輸送ワ級", "補給艦", "", 0, 0, 0));
            this.put("514", new ShipInfoDto("駆逐イ級", "駆逐艦", "elite", 0, 0, 0));
            this.put("515", new ShipInfoDto("駆逐ロ級", "駆逐艦", "elite", 0, 0, 0));
            this.put("516", new ShipInfoDto("駆逐ハ級", "駆逐艦", "elite", 0, 0, 0));
            this.put("517", new ShipInfoDto("駆逐ニ級", "駆逐艦", "elite", 0, 0, 0));
            this.put("518", new ShipInfoDto("軽巡ホ級", "軽巡洋艦", "elite", 0, 0, 0));
            this.put("519", new ShipInfoDto("軽巡ヘ級", "軽巡洋艦", "elite", 0, 0, 0));
            this.put("520", new ShipInfoDto("軽巡ト級", "軽巡洋艦", "elite", 0, 0, 0));
            this.put("521", new ShipInfoDto("雷巡チ級", "重雷装巡洋艦", "elite", 0, 0, 0));
            this.put("522", new ShipInfoDto("重巡リ級", "重巡洋艦", "elite", 0, 0, 0));
            this.put("523", new ShipInfoDto("軽母ヌ級", "軽空母", "elite", 0, 0, 0));
            this.put("524", new ShipInfoDto("戦艦ル級", "戦艦", "elite", 0, 0, 0));
            this.put("525", new ShipInfoDto("空母ヲ級", "正規空母", "elite", 0, 0, 0));
            this.put("526", new ShipInfoDto("輸送ワ級", "補給艦", "elite", 0, 0, 0));
            this.put("527", new ShipInfoDto("重巡リ級", "重巡洋艦", "flagship", 0, 0, 0));
            this.put("528", new ShipInfoDto("空母ヲ級", "正規空母", "flagship", 0, 0, 0));
            this.put("529", new ShipInfoDto("戦艦ル級", "戦艦", "flagship", 0, 0, 0));
            this.put("530", new ShipInfoDto("潜水カ級", "潜水艦", "", 0, 0, 0));
            this.put("531", new ShipInfoDto("潜水ヨ級", "潜水艦", "", 0, 0, 0));
            this.put("532", new ShipInfoDto("潜水カ級", "潜水艦", "elite", 0, 0, 0));
            this.put("533", new ShipInfoDto("潜水ヨ級", "潜水艦", "elite", 0, 0, 0));
            this.put("534", new ShipInfoDto("潜水カ級", "潜水艦", "flagship", 0, 0, 0));
            this.put("535", new ShipInfoDto("潜水ヨ級", "潜水艦", "flagship", 0, 0, 0));
            this.put("536", new ShipInfoDto("浮遊要塞", "航空戦艦", "", 0, 0, 0));
            this.put("537", new ShipInfoDto("浮遊要塞", "航空戦艦", "", 0, 0, 0));
            this.put("538", new ShipInfoDto("浮遊要塞", "航空戦艦", "", 0, 0, 0));
            this.put("539", new ShipInfoDto("泊地棲鬼", "航空戦艦", "", 0, 0, 0));
            this.put("540", new ShipInfoDto("泊地棲姫", "航空戦艦", "", 0, 0, 0));
            this.put("541", new ShipInfoDto("戦艦タ級", "戦艦", "", 0, 0, 0));
            this.put("542", new ShipInfoDto("戦艦タ級", "戦艦", "elite", 0, 0, 0));
            this.put("543", new ShipInfoDto("戦艦タ級", "戦艦", "flagship", 0, 0, 0));
            this.put("544", new ShipInfoDto("装甲空母鬼", "航空戦艦", "", 0, 0, 0));
            this.put("545", new ShipInfoDto("装甲空母姫", "航空戦艦", "", 0, 0, 0));
            this.put("546", new ShipInfoDto("南方棲鬼", "航空戦艦", "", 0, 0, 0));
            this.put("547", new ShipInfoDto("南方棲戦鬼", "航空戦艦", "", 0, 0, 0));
            this.put("548", new ShipInfoDto("南方棲戦姫", "航空戦艦", "", 0, 0, 0));
            this.put("549", new ShipInfoDto("護衛要塞", "航空戦艦", "", 0, 0, 0));
            this.put("550", new ShipInfoDto("護衛要塞", "航空戦艦", "", 0, 0, 0));
            this.put("551", new ShipInfoDto("護衛要塞", "航空戦艦", "", 0, 0, 0));
            this.put("552", new ShipInfoDto("駆逐ロ級", "駆逐艦", "flagship", 0, 0, 0));
            this.put("553", new ShipInfoDto("駆逐ハ級", "駆逐艦", "flagship", 0, 0, 0));
            this.put("554", new ShipInfoDto("軽巡ホ級", "軽巡洋艦", "flagship", 0, 0, 0));
            this.put("555", new ShipInfoDto("軽巡ヘ級", "軽巡洋艦", "flagship", 0, 0, 0));
            this.put("556", new ShipInfoDto("飛行場姫", "航空戦艦", "", 0, 0, 0));
            this.put("557", new ShipInfoDto("戦艦棲姫", "戦艦", "", 0, 0, 0));
            this.put("558", new ShipInfoDto("輸送ワ級", "補給艦", "flagship", 0, 0, 0));
            this.put("559", new ShipInfoDto("雷巡チ級", "重雷装巡洋艦", "flagship", 0, 0, 0));
            this.put("560", new ShipInfoDto("軽母ヌ級", "軽空母", "flagship", 0, 0, 0));
            this.put("561", new ShipInfoDto("戦艦レ級", "航空戦艦", "", 0, 0, 0));
            this.put("562", new ShipInfoDto("戦艦レ級", "航空戦艦", "elite", 0, 0, 0));
            this.put("563", ShipInfoDto.EMPTY);
            this.put("564", new ShipInfoDto("駆逐イ級", "駆逐艦", "flagship", 0, 0, 0));
            this.put("565", new ShipInfoDto("空母ヲ級改", "正規空母", "flagship", 0, 0, 0));
            this.put("566", new ShipInfoDto("重巡リ級改", "重巡洋艦", "flagship", 0, 0, 0));
            this.put("567", new ShipInfoDto("戦艦ル級改", "戦艦", "flagship", 0, 0, 0));
            this.put("568", ShipInfoDto.EMPTY);
            this.put("569", ShipInfoDto.EMPTY);
            this.put("570", new ShipInfoDto("潜水ソ級", "潜水艦", "", 0, 0, 0));
            this.put("571", new ShipInfoDto("潜水ソ級", "潜水艦", "elite", 0, 0, 0));
            this.put("572", new ShipInfoDto("潜水ソ級", "潜水艦", "flagship", 0, 0, 0));
            this.put("573", new ShipInfoDto("港湾棲姫", "航空戦艦", "", 0, 0, 0));
            this.put("574", new ShipInfoDto("離島棲鬼", "航空戦艦", "", 0, 0, 0));
            this.put("575", new ShipInfoDto("駆逐イ級後期型", "駆逐艦", "", 0, 0, 0));
            this.put("576", new ShipInfoDto("駆逐ロ級後期型", "駆逐艦", "", 0, 0, 0));
            this.put("577", new ShipInfoDto("駆逐ハ級後期型", "駆逐艦", "", 0, 0, 0));
            this.put("578", new ShipInfoDto("駆逐ニ級後期型", "駆逐艦", "", 0, 0, 0));
            this.put("579", new ShipInfoDto("空母ヲ級", "正規空母", "flagship", 0, 0, 0));
            this.put("580", ShipInfoDto.EMPTY);
            this.put("581", new ShipInfoDto("北方棲姫", "航空戦艦", "", 0, 0, 0));
            this.put("582", new ShipInfoDto("北方棲姫", "航空戦艦", "", 0, 0, 0));
            this.put("583", new ShipInfoDto("中間棲姫", "航空戦艦", "", 0, 0, 0));
            this.put("584", new ShipInfoDto("中間棲姫", "航空戦艦", "", 0, 0, 0));
            this.put("585", new ShipInfoDto("空母棲鬼", "正規空母", "", 0, 0, 0));
            this.put("586", new ShipInfoDto("空母棲姫", "正規空母", "", 0, 0, 0));
            this.put("587", new ShipInfoDto("北方棲姫", "航空戦艦", "", 0, 0, 0));
            this.put("588", new ShipInfoDto("北方棲姫", "航空戦艦", "", 0, 0, 0));
            this.put("589", new ShipInfoDto("北方棲姫", "航空戦艦", "", 0, 0, 0));
            this.put("590", new ShipInfoDto("北方棲姫", "航空戦艦", "", 0, 0, 0));
            this.put("591", new ShipInfoDto("軽巡ツ級", "軽巡洋艦", "", 0, 0, 0));
            this.put("592", new ShipInfoDto("軽巡ツ級", "軽巡洋艦", "elite", 0, 0, 0));
            this.put("593", ShipInfoDto.EMPTY);
            this.put("594", new ShipInfoDto("重巡ネ級", "重巡洋艦", "", 0, 0, 0));
            this.put("595", new ShipInfoDto("重巡ネ級", "重巡洋艦", "elite", 0, 0, 0));
            this.put("596", ShipInfoDto.EMPTY);
            this.put("597", new ShipInfoDto("駆逐棲姫", "駆逐艦", "", 0, 0, 0));
            this.put("598", new ShipInfoDto("駆逐棲姫", "駆逐艦", "", 0, 0, 0));
            this.put("599", new ShipInfoDto("空母水鬼", "正規空母", "", 0, 0, 0));
            this.put("600", new ShipInfoDto("空母水鬼", "正規空母", "", 0, 0, 0));
            this.put("601", new ShipInfoDto("軽巡棲鬼", "軽巡洋艦", "", 0, 0, 0));
            this.put("602", new ShipInfoDto("軽巡棲鬼", "軽巡洋艦", "", 0, 0, 0));
            this.put("603", new ShipInfoDto("戦艦水鬼", "戦艦", "", 0, 0, 0));
            this.put("604", new ShipInfoDto("戦艦水鬼", "戦艦", "", 0, 0, 0));
        }
    };

    // 始めてアクセスがあった時に読み込む
    static {
        update();
    }

    /**
     * 艦娘を取得します
     * 
     * @param id ID
     * @return 艦娘
     */
    public static ShipInfoDto get(String id) {
        ShipInfoDto dto = SHIP.get(id);
        if (dto == null)
            return ShipInfoDto.EMPTY;
        return dto;
    }

    /**
     * マスターデータから更新
     */
    public static void update() {
        for (Entry<String, ShipInfoDto> entry : MasterData.get().getStart2().getShips().entrySet()) {
            SHIP.put(entry.getKey(), entry.getValue());
        }
    }

    public static Map<String, ShipInfoDto> get() {
        return SHIP;
    }

    /** 敵艦名からの変換マップ */
    public static Map<String, ShipInfoDto> getEnemyNameMap() {
        Map<String, ShipInfoDto> nameMap = new HashMap<>();
        for (ShipInfoDto ship : SHIP.values()) {
            nameMap.put(ship.getFullName(), ship);
        }
        return nameMap;
    }

    /** 改造最終艦のID */
    public static int getCharId(ShipInfoDto shipinfo) {
        int charId = shipinfo.getShipId();
        int afterShipId = shipinfo.getAftershipid();
        while (afterShipId != 0) {
            charId = afterShipId;
            afterShipId = Ship.get(String.valueOf(afterShipId)).getAftershipid();
        }
        return charId;
    }

    public static void dumpCSV(OutputStreamWriter fw) throws IOException {
        fw.write(StringUtils.join(new String[] {
                "名前", "ID", "艦種", "速力", "耐久", "燃料", "弾薬",
                "火力", "火力(max)", "雷装", "雷装(max)", "対空", "対空(max)", "装甲", "装甲(max)", "射程", "運", "運(max)",
                "搭載機数1", "搭載機数2", "搭載機数3", "搭載機数4" },
                ','));
        fw.write("\n");

        for (String key : SHIP.keySet()) {
            ShipInfoDto dto = Ship.get(key);
            ShipParameters param = dto.getParam();
            ShipParameters max = dto.getMax();
            if (dto.getName().length() > 0) {
                String name = dto.getName();
                if (dto.getMaxBull() == 0) { // 敵
                    if (!StringUtils.isEmpty(dto.getFlagship())) {
                        name += " " + dto.getFlagship();
                    }
                }
                fw.write(StringUtils.join(new String[] {
                        name, // 名前
                        Integer.toString(dto.getShipId()), // ID
                        dto.getType(), // 
                        Integer.toString(dto.getMax().getSoku()),
                        Integer.toString(dto.getMax().getHP()),
                        Integer.toString(dto.getMaxFuel()),
                        Integer.toString(dto.getMaxBull()),
                        Integer.toString(param.getHoug()),
                        Integer.toString(max.getHoug()),
                        Integer.toString(param.getRaig()),
                        Integer.toString(max.getRaig()),
                        Integer.toString(param.getTyku()),
                        Integer.toString(max.getTyku()),
                        Integer.toString(param.getSouk()),
                        Integer.toString(max.getSouk()),
                        Integer.toString(param.getLeng()),
                        Integer.toString(param.getLuck()),
                        Integer.toString(max.getLuck()),
                        Integer.toString(dto.getMaxeq()[0]),
                        Integer.toString(dto.getMaxeq()[1]),
                        Integer.toString(dto.getMaxeq()[2]),
                        Integer.toString(dto.getMaxeq()[3]) }, ','));
                fw.write("\n");
            }
        }
    }
}
