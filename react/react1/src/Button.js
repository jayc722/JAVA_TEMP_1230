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

function Button({text = "버튼", style}){	//기본값 지정
	return(
		<button style={style}>{text}</button>
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