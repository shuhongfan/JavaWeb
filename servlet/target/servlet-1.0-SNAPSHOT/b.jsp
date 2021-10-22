<%@ page import="com.shf.pojo.Person" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/10/20
  Time: 9:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Person person = new Person();
    person.setName("展示");
    person.setPhones(new String[]{"115165","46486","468486"});

    ArrayList<String> citys = new ArrayList<>();
    citys.add("北京");
    citys.add("上海");
    citys.add("深圳");
    person.setCities(citys);

    HashMap<String, Object> map = new HashMap<>();
    map.put("key1","value1");
    map.put("key2","value2");
    map.put("key3","value3");
    map.put("k-e-y","value3");
    person.setMap(map);

    pageContext.setAttribute("p",person);

    request.setAttribute("emptyNull",null);
    request.setAttribute("emptyStr","");
    request.setAttribute("emptyArr",new Object[]{});
    request.setAttribute("emptyList",new ArrayList[]{});
    request.setAttribute("emptyMap",new HashMap<String, Object>());
%>

输出Person：  ${p} <br>
输出Person的name属性： ${p.name} <br>
输出Person的phones数组： ${p.phones[0]} <br>
输出Person的cities集合： ${p.cities} <br>
输出Person的list集合中个别元素值： ${p.cities[2]} <br>
输出Person的map集合： ${p.map} <br>
输出Person的map集合中某个key的值： ${p.map.key1} <br>

输出Person的age属性： ${p.age} <br>

<hr>
${12==12} 或 ${12 eq 12} <br>
${12!=12} 或 ${12 ne 12} <br>
${12<12} 或 ${12 lt 12} <br>
${12>12} 或 ${12 gt 12} <br>
${12<=12} 或 ${12 le 12} <br>
${12>=12} 或 ${12 ge 12} <br>
${18 div 12}
${18 mod 12}

<hr>
${empty emptyNull}
${empty emptyStr}
${empty emptyArr}
${empty emptyList}
${empty emptyMap}

<hr>
${12==12?"真":"假"}

<hr>
${p.map.["m.a.p"]}

<hr>


</body>
</html>
