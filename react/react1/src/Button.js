function Button1(props){
	return(
		<button>{props.text}</button>
	);

}

function Button2({text}){
	return(
		<button>{text}</button>
	);

}

function Button({text, style}){
	return(
		<button style={style}>{text}</button>
	);

}

function ButtonButton(props){
	return(
		<button style={props.style}>{props.text}</button>
	);

}

export {Button1, Button2, Button};