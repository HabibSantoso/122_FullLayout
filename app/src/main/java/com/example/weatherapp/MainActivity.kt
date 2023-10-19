package com.example.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.layout.ColumnScopeInstance.align
//import androidx.compose.foundation.layout.BoxScopeInstance.align
import androidx.compose.foundation.lazy.layout.getDefaultLazyLayoutKey
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.ui.theme.WeatherAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Homescreen()
                }
            }
        }
    }
}

@Composable
fun Homescreen() {
    Column(modifier = Modifier
        .padding(20.dp)
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "WHEATHER APP")

        Spacer(modifier = Modifier.padding(13.dp))

        StatusBox()

        Spacer(modifier = Modifier.padding(13.dp))

        LocnTemp()

        Spacer(modifier = Modifier.padding(13.dp))

        DetailBox()


    }
}


@Composable
fun StatusBox(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(25.dp))
        .background(color = Color.Cyan)) {
        
        Column(modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = R.drawable.rain_status),
                contentDescription =null,
            modifier = Modifier.size(200.dp))
            
            Text(text = "Rain", fontSize = 30.sp)
        }

    }

}

@Composable
fun LocnTemp() {
    Text(text = "21C", fontWeight = FontWeight.Bold, fontSize = 64.sp)
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(painter = painterResource(id = R.drawable.baseline_location_on_24),
            contentDescription = null)

        Spacer(modifier = Modifier.padding(3.dp))

        Text(text = "Yogyakarta", fontSize = 30.sp)
    }

    Spacer(modifier = Modifier.padding(13.dp))

    Text(text = "Kasihan, Bantul, Daerah Istimewah Yogyakarta",
        fontSize = 20.sp, color = Color.Gray, textAlign = TextAlign.Center)
    
}

@Composable
fun DetailBox() {
    Box(modifier = Modifier
        .fillMaxWidth().padding(25.dp)
        .clip(RoundedCornerShape(25.dp))
        .background(color = Color.Cyan)) {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize().padding(35.dp)) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "Humidity", textAlign = TextAlign.Center)
                    Text(text = "60%", textAlign = TextAlign.Center)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "Wind", textAlign = TextAlign.Center)
                    Text(text = "20 m/s", textAlign = TextAlign.Center)
                }
            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "Sunrice", textAlign = TextAlign.Center)
                    Text(text = "05:25", textAlign = TextAlign.Center)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "Sunset", textAlign = TextAlign.Center)
                    Text(text = "17:45", textAlign = TextAlign.Center)
                }
            }
        }
    }
    
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WeatherAppTheme {
        Homescreen()
    }
}