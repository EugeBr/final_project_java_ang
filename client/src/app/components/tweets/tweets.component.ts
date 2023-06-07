import { Component, OnInit } from '@angular/core';
import { TweetService } from 'src/app/services/tweet.service';

@Component({
  selector: 'app-tweets',
  templateUrl: './tweets.component.html',
  styleUrls: ['./tweets.component.css']
})
export class TweetsComponent implements OnInit{

  tweetList!: any;

  constructor(private tweetService: TweetService) { };

  ngOnInit(): void {
    this.getAllTweets();
  }

  getAllTweets(): void {
    this.tweetService.getTweets().subscribe(
      {
        next: (data) => {
          this.tweetList = data;
        },
        error: (e) => {
          console.log(e);
        }
      }
    );
  }
}
