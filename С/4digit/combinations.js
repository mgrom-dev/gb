let str_arr = "12369874159875369514709632580963214781234567890147852369074109630852963085207410";
let arr1 = [];
console.log(arr1);
for (let i = 0; i < str_arr.length - 3; i++) {
    let chunk = str_arr.substring(i, i + 4);
    if (!arr1.includes(chunk))
        arr1.push(chunk);
}
str_arr = str_arr.split("").reverse().join("");
for (let i = 0; i < str_arr.length - 3; i++) {
    let chunk = str_arr.substring(i, i + 4);
    if (!arr1.includes(chunk))
        arr1.push(chunk);
}
let str = "";
arr1.sort().forEach(s => str += "- " + s + "\n");
console.log(arr1.length);
console.log(str);