//
//  RepositoryListRow.swift
//  iosApp
//
//  Created by Vika on 18.08.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import Kingfisher
import shared

fileprivate extension Appearance {
	var imageSideSize: CGFloat { 40 }
	var rightImageOffset: CGFloat { 10 }
	var rightTextOffset: CGFloat { 10 }
}

struct RepositoryListRow: View {
	private let appearance: Appearance = Appearance()
	var item: RepositoryInfo
	
	var body: some View {
		HStack {
			KFImage(URL(string: item.owner.avatar))
				.placeholder {
					GithubLogoImage()
				}
				.resizable()
				.aspectRatio(contentMode: .fill)
				.frame(width: appearance.imageSideSize, height: appearance.imageSideSize)
				.clipShape(Circle())
			Spacer()
				.frame(width: appearance.rightImageOffset)
			VStack {
				Text(item.owner.login)
					.font(Font.subheadline)
					.bold()
					.frame(maxWidth: .infinity, alignment: .leading)
				Link(item.name, destination: URL(string: item.url)!)
					.frame(maxWidth: .infinity, alignment: .leading)
			}
			Spacer()
				.frame(width: appearance.rightTextOffset)
		}
	}
}
