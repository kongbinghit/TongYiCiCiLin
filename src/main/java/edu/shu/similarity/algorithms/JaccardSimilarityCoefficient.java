package edu.shu.similarity.algorithms;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * Created with IntelliJ IDEA. 2015/8/9 14:22
 * </p>
 * <p>
 * ClassName:JaccardSimilarityCoefficient
 * </p>
 * <p>
 * Description:杰卡德相似系数，是衡量两个集合的相似度的一种指标，J(A,B)=|A∩B|/|A∪B|
 * 杰卡德距离，是衡量两个集合中不同元素占所有元素的比例来衡量两个集合的区分度，Ja(A,B)=1-J(A,B)
 * </P>
 *
 * @author Wang Xu
 * @version V1.0.0
 * @since V1.0.0
 */
public class JaccardSimilarityCoefficient {
    public double getJSC(String str1, String str2) {
        if (StringUtils.isEmpty(str1) && StringUtils.isEmpty(str2)) {
            return 1;
        }
        Set<Character> s1 = new HashSet<Character>();
        Set<Character> s2 = new HashSet<Character>();
        str1 = Preconditions.checkNotNull(str1);
        str2 = Preconditions.checkNotNull(str2);
        char[] chars1 = str1.toLowerCase().toCharArray();
        char[] chars2 = str2.toLowerCase().toCharArray();
        for (char c : chars1) {
            s1.add(c);
        }
        for (char c : chars2) {
            s2.add(c);
        }

        //求交集
        Set<Character> intersection = new HashSet<Character>();
        intersection.addAll(s1);
        intersection.retainAll(s2);

        //求并集
        Set<Character> union = new HashSet<Character>();
        union.addAll(s1);
        union.addAll(s2);

        return (double) intersection.size() / union.size();
    }

    @Test
    public void test() {
        System.out.println(getJSC("aaabbb", "b"));
    }

}
