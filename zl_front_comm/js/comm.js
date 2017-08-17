/**
 * Created by hlw on 2017/8/17.
 */
var base_comm = {};

/**
 * 两个日期间相隔的天数
 *
 * @param startDate 开始时间
 * @param endDate 结束时间
 * @returns {Number} 天数
 */
base_comm.dateLimit = function(startDate, endDate){
    var days = endDate.getTime() - startDate.getTime();
    return parseInt(days / (1000 * 60 * 60 * 24));
}

/**
 * 转换为日期
 *
 * @param inObj 输入对象
 * @returns {Date} 日期
 */
base_comm.toDate = function(inObj){
    return (new Date(inObj));
}

/**
 * 转换为数字
 *
 * @param inObj  输入对象
 * @returns {number|*}
 */
base_comm.toNumber = function(inObj){
    var _inObj = Number(inObj);
    return _inObj;
}

/**
 * 判断输入对象是否为空，如果为空返回true，否则返回false
 *
 * @param inObj 输入对象
 * @returns {boolean}
 */
base_comm.isEmpty = function(inObj){
    return inObj == null || inObj == undefined || inObj == 'null' || inObj == '' || inObj.length == 0;
}

/**
 * 判断是否为数字
 *
 * @param inObj 输入对象
 * @param type 数字类型
 *              0-整数；1-正整数；2-负整数；5-浮点数；6-正浮点数；7-负浮点数；
 *              11-非负整数（正整数 + 0）；12-非正整数（负整数 + 0）；16-非负浮点数（正浮点数 + 0）；17-非正浮点数（负浮点数 + 0）
 * @returns {boolean}
 */
base_comm.isNumber = function(inObj, type){
    // 整数
    if (type == 0) {
        return "^-?\\d+$".test(inObj);
    }
    // 正整数
    if (type == 1) {
        return "^[0-9]*[1-9][0-9]*$".test(inObj);
    }
    // 负整数
    if (type == 2) {
        return "^-[0-9]*[1-9][0-9]*$".test(inObj);
    }
    // 浮点数
    if (type == 5) {
        return "^(-?\\d+)(".test(inObj);
    }
    // 正浮点数
    if (type == 6) {
        return "^(([0-9]+\\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\\.[0-9]+)|([0-9]*[1-9][0-9]*))$".test(inObj);
    }
    // 负浮点数
    if (type == 7) {
        return "^(-(([0-9]+\\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\\.[0-9]+)|([0-9]*[1-9][0-9]*)))$".test(inObj);
    }

    // 非负整数（正整数 + 0）
    if (type == 11) {
        return "^\\d+$".test(inObj);
    }
    // 非正整数（负整数 + 0）
    if (type == 12) {
        return "^((-\\d+)|(0+))$".test(inObj);
    }

    // 非负浮点数（正浮点数 + 0）
    if (type == 16) {
        return "^\\d+(".test(inObj);
    }
    // 非正浮点数（负浮点数 + 0）
    if (type == 17) {
        return "^((-\\d+(".test(inObj);
    }

    return false;
}