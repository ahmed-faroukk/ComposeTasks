package com.example.composetask_1.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetask_1.R
const val role = "  Watching every video gives you 50 Coins,\n" +
        "however Closing video in between won't give\n" +
        "                      you any coins"


@Composable
fun HomeScreen(){
    Column(Modifier
        .fillMaxSize()
        .background(colorResource(id = R.color.primary_app_color)) ,
        horizontalAlignment =  Alignment.CenterHorizontally) {

        VideoIcon(modifier = Modifier.padding(top = 120.dp))
        Text1(txt = "Watch\nVideo" , modifier = Modifier.padding(top = 15.dp))
        Text2(txt = role ,
        modifier = Modifier.padding(top = 15.dp))
        var firstDot by remember {
          mutableStateOf(true)
        }

        DostHandler(stateChanges = firstDot , modifier = Modifier.padding(top = 15.dp))


    }
}


@Composable
fun VideoIcon(modifier: Modifier = Modifier){
    Box(modifier
        .background(colorResource(id = R.color.icon_background), shape = RoundedCornerShape(55.dp))
        .size(160.dp)) {
        Icon(painter = painterResource(id = R.drawable.ic_round_ondemand_video_24),
            contentDescription ="videoIcon" ,
            Modifier
                .padding(35.dp)
                .align(Alignment.Center)
                .fillMaxSize() , tint = Color.White )
    }
}

@Composable
fun Text1(txt :String , modifier: Modifier = Modifier){
    Text( modifier = modifier ,text = txt ,
        color = Color.White ,
        fontSize = 50.sp , fontWeight = FontWeight.Bold)
}

@Composable
fun Text2(txt :String , modifier: Modifier = Modifier){
    Text( modifier = modifier.padding(start = 40.dp , end = 40.dp) ,text = txt ,
        color = Color.Gray ,
        fontWeight = FontWeight.Bold ,
    fontSize = 15.sp)
}
@Composable
fun DostHandler(stateChanges : Boolean , modifier: Modifier = Modifier){
        val activeColor : Color = Color.White
        val inactiveColor : Color = Color.Gray
    var state by remember {
        mutableStateOf(stateChanges)
    }
    Column {
        Row( modifier =  modifier.fillMaxWidth() , horizontalArrangement = Arrangement.Center) {
            Spacer(modifier = Modifier
                .padding(5.dp)
                .size(10.dp)
                .background(if (state) activeColor else inactiveColor, shape = CircleShape))
            Spacer(modifier = Modifier
                .padding(5.dp)
                .size(10.dp)
                .background(if (state) inactiveColor else activeColor, shape = CircleShape))
        }

        val background : Color = colorResource(id = R.color.btn_background)
        Button(onClick = {
            state = !state
        } , modifier = modifier
            .fillMaxWidth().padding(50.dp)
            .height(70.dp)
            .clip(shape = RoundedCornerShape(22.dp)) , colors = ButtonDefaults.buttonColors(backgroundColor = background)) {
            Text(text = "CONTINUE" )
        }
    }


}

