package cn.hyx.bg;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import cn.hyx.bg.entity.SixtyFourSymbolsEntity;
import cn.hyx.bg.mapper.SixtyFourSymbolsMapper;

import static java.util.Collections.*;

@SpringBootTest
class BgApplicationTests {
    // 大衍之数五十
    int DA_DAO = 50;
    // 取一为太极
    int TAI_JI = 1;
    // 划分四季
    int SJ = 4;

    @Autowired
    private SixtyFourSymbolsMapper symbolsMapper;

    @Test
    void contextLoads() {
        // 以四九起八卦
        int bg = DA_DAO - TAI_JI;
        int i = 1;
        String str = " 6 \n 5 \n 4 \n 3 \n 2 \n 1 ";
        List<Integer> list = new ArrayList<>(6);
        while (i <= 6) {
            int bgs = bgs(bg);
            list.add(bgs);
            switch (bgs) {
                case 6:
                    str = str.replace(i + "", "六老阴 - - ");
                    break;
                case 7:
                    str = str.replace(i + "", "七少阳 --- ");
                    break;
                case 8:
                    str = str.replace(i + "", "八少阴 - - ");
                    break;
                case 9:
                    str = str.replace(i + "", "九老阳 --- ");
                    break;
                default:
                    break;
            }
            i++;
        }
        reverse(list);
        System.out.println(str);
        System.out.println(list.toString());

    }

    int bgs(int bg) {
        int i = 1;
        while (i < SJ) {
            bg = bgf(bg);
            i++;
        }
        return (bg / 4);
    }

    int bgf(int bg) {
        Random random = new Random();
        // 阴阳二分左
        int yyz = random.nextInt(bg);
        // 阴阳二分右
        int yyy = bg - yyz;
        // 以左为天，先取其一，后分四季
        yyz = (yyz - 1) % SJ;
        // 右为地分四季
        yyy = yyy % SJ;
        // 取阴阳其奇合一
        return (bg - ((yyz == 0 ? 4 : yyz) + (yyy == 0 ? 4 : yyy) + 1));

    }

    @Test
    void mybatisPlusTest() {
        SixtyFourSymbolsEntity entity = symbolsMapper.selectById(1);

        System.out.println(entity);

    }


}
