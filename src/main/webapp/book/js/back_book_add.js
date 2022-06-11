const form = document.querySelector('form');
const title = document.querySelector('#title');
const ISBN = document.querySelector('#ISBN');
const book_category = document.querySelector('#book_category');
const author = document.querySelector('#author');
const edition = document.querySelector('#edition');
const status = {'title': false, 'ISBN': false};


/**
 * 函式創建器
 * @param {string}name 對應的表單字段名稱
 * @param {object}inputObj input物件
 * @param {function}checkFunc 判斷函式
 * @param {string}errInfo 提示錯誤訊息
 * @return {inner} 事件處理函式
 */
function generate(name, inputObj, checkFunc, errInfo) {
    function inner(event) {
        const classList = inputObj.classList;
        classList.remove('is-valid');
        classList.remove('is-invalid');
        let class_style = '';
        if (!checkFunc()) {
            classList.add('is-invalid')
        } else {
            classList.add('is-valid')
        }
    }

    inputObj.addEventListener('blur', inner);
}

/**
 * 初始化各式綁定事件
 */
function init() {
    /**
     * 使用sweetAlter綁定提交事件
     */
    form.addEventListener('submit', event => {
        event.preventDefault();    // ←取消預設事件行為
        swal({
            title: "確認送出 ?",
            text: "請再次確認輸入資料",
            icon: "info",
            buttons: true,
            dangerMode: true,
        })
            .then((willDelete) => {
                if (willDelete) {
                    swal("已成功建立此書籍資訊", {
                        icon: "success",
                    });
                    // 送出資料
                    event.target.submit();
                } else {
                    swal("未新增任何訊息");
                }
            });

    });
}

init();