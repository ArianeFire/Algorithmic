/**
 * @param {string} a
 * @param {string} b
 * @return {string}
 */
var addBinary = function(a, b) {
    
    var A = Array.from(a).reverse();
    var B = Array.from(b).reverse();
    var AL = A.length;
    var BL = B.length;
    var R = "0";
	var SHORT_ARR = AL >= BL ? B : A;
	var BIG_ARR = (AL >= BL ? A : B);
	var SL = SHORT_ARR.length;
	var RESULT = [];
    
    BIG_ARR.forEach(function(elt, index, arr){
        
	    var SAi = (SL > index ? SHORT_ARR[index] : "0");
	    var Sum = addBi(elt, SAi, R);
		R = Sum[1];

		RESULT.unshift(Sum[0])
	});
			
    var S = RESULT.join("");
    
    return R != "0" ? R + S : S;
    
};

var addBi = function(a, b, rest){
    var A = eval(a);
    var B = eval(b);
    var R = eval(rest);
    var S = A + B + R;
    
    if(S == 0) return ["0", "0"];
    if(S == 1) return ["1", "0"];
    if(S == 2) return ["0", "1"];
    
    return ["1", "1"];
}

/** TEST CASE **/
print(addBinary("0", "0"))
print(addBinary("0", "1"))
print(addBinary("10", "1"))
print(addBinary("1010", "1011"))