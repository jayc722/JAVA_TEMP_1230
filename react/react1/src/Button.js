import PropTypes from 'prop-types';

function Button1(props){
	return(
		<button>{props.test}</button>
	);

}

function Button2({text}){
	return(
		<button>{text}</button>
	);

}

function Button({text = "버튼", style, click}){	//기본값 지정		//click = 부모컴포넌트에서 보내준 요소 stateSample에 있는 Button은 컴포넌트라 여기 추가해줘야함
	return(
		<button style={style} onClick={click}>{text}</button>
	);

}

function ButtonProps(props){
	return(
		<button style={props.style}>{props.text}</button>
	);

}


Button.propTypes = {
	text : PropTypes.string,
	style : PropTypes.object
}

Button.defaultProps = {
	text : "버튼"
}




export {Button1, Button2, Button};